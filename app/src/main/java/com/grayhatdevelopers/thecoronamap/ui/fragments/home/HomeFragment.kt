package com.grayhatdevelopers.thecoronamap.ui.fragments.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.grayhatdevelopers.thecoronamap.R
import com.grayhatdevelopers.thecoronamap.adapters.countrystats.CountryStatsAdapter
import com.grayhatdevelopers.thecoronamap.databinding.FragmentHomeBinding
import com.grayhatdevelopers.thecoronamap.repo.Repository
import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseFragment
import com.grayhatdevelopers.thecoronamap.ui.fragments.webview.WebViewClientHelper
import com.grayhatdevelopers.thecoronamap.utils.InjectorUtils
import com.grayhatdevelopers.thecoronamap.utils.getCurrentTime
import com.grayhatdevelopers.thecoronamap.utils.hasNetwork
import kotlinx.coroutines.*

class HomeFragment : BaseFragment(), CoroutineScope by MainScope() {

    private lateinit var mViewModel: HomeViewModel
    private lateinit var homeFragmentBinding : FragmentHomeBinding
    private lateinit var countryStatsAdapter: CountryStatsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        homeFragmentBinding.apply {
            lifecycleOwner = this@HomeFragment
            mViewModel = InjectorUtils.provideHomeViewModel()
            viewModel = mViewModel
        }
        return homeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupDrawer()
        setupWebView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeHomeActions()
    }

    private fun observeHomeActions() {
        mViewModel.homeActions.observe(viewLifecycleOwner) {
            when (it) {
                HomeActions.OpenFulMap -> {
                    Log.d(TAG, "Opening Full Map")
                    val link = "https://www.thecoronamap.com/"
                    val bundle = bundleOf("link" to link)
                    baseViewModel.navigate(HomeFragmentDirections.actionHomeFragmentToWebViewFragment(link), bundle)
                }
                is HomeActions.ShowOrHideExpandedStats -> {
                    if (it.show) {
                        Log.d(TAG, "Showing Expanded Stats")
                        // populate recycler view
                        populateRecyclerView()
                    } else {
                        Log.d(TAG, "Hiding Expanded Stats")
                    }
                }
                HomeActions.OpenReportFragment -> {
                    Log.d(TAG, "Opening Report Fragment")
                    baseViewModel.navigate(HomeFragmentDirections.actionHomeFragmentToReportFragment())
                }
                HomeActions.OpenSymptomsChecker -> {
                    Log.d(TAG, "Opening Symptoms Checker")
                    val link = "https://tcm-symptoms-checker.web.app/"
                    val bundle = bundleOf("link" to link)
                    baseViewModel.navigate(HomeFragmentDirections.actionHomeFragmentToWebViewFragment(link), bundle)
                }
            }
        }
    }

    private fun populateRecyclerView() {
        // insert dummy data
        launch {
            if (hasNetwork(context!!))
                Repository.getInstance().getAllCountriesData(getCurrentTime())
            else Repository.getInstance().getCountriesCachedData()
        }
        countryStatsAdapter = CountryStatsAdapter()
        homeFragmentBinding.expandedStats.countryStatsList.apply {
            adapter = countryStatsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        countryStatsAdapter.apply {
            // observe data changes in the list
            Repository.getInstance().countryStats.observe(viewLifecycleOwner) {
                this.submitList(it)
            }
        }
        homeFragmentBinding.expandedStats.progressBar.visibility = View.GONE
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        homeFragmentBinding.homeWebview.apply {
            webViewClient =
            WebViewClientHelper()
           settings.javaScriptEnabled = true
           loadUrl("https://mobile-thecoronamap.web.app/")
        }
    }


    @SuppressLint("RtlHardcoded")
    private fun setupDrawer() {
        /**
         * setup navigation drawer
         */
        homeFragmentBinding.navIcon.setOnClickListener {
            homeFragmentBinding.drawerLayout.openDrawer(Gravity.LEFT)
            homeFragmentBinding.homeRootView.alpha = 0.5.toFloat()
        }

        homeFragmentBinding.drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {

            override fun onDrawerStateChanged(newState: Int) {
                Log.d(TAG, "drawer state changed: $newState")
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                Log.d(TAG, "drawer slided")
            }

            override fun onDrawerClosed(drawerView: View) {
                Log.d(TAG, "drawer closed")
                homeFragmentBinding.homeRootView.alpha = 1.toFloat()
            }

            override fun onDrawerOpened(drawerView: View) {
                Log.d(TAG, "drawer opened")
            }

        })
    }

    companion object {
        private const val TAG = "HomeFragment"
    }
}