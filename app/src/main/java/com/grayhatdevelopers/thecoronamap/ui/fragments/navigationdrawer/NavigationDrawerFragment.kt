package com.grayhatdevelopers.thecoronamap.ui.fragments.navigationdrawer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.grayhatdevelopers.thecoronamap.databinding.FragmentNavigationDrawerBinding
import com.grayhatdevelopers.thecoronamap.models.User
import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseFragment
import com.grayhatdevelopers.thecoronamap.utils.InjectorUtils

class NavigationDrawerFragment : BaseFragment() {

    private lateinit var mViewModel: NavigationDrawerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentNavigationDrawerBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            lifecycleOwner = this@NavigationDrawerFragment
            mViewModel = InjectorUtils.provideNavigationDrawerViewModel()
            viewModel = mViewModel
            user = User("Hamza Maqsood", "hamza@gmail.com", "Islamabad, Pakistan")
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeNavigationDrawerActions()
    }

    private fun observeNavigationDrawerActions() {
        mViewModel.navigationDrawerActions.observe(viewLifecycleOwner) {
            when (it) {
                NavigationDrawerActions.OpenSafetyTips -> {
                    Log.d(TAG, "Opening Safety Tips")
                }
                NavigationDrawerActions.OpenSettings -> {
                    Log.d(TAG, "Opening Settings")
                }
                NavigationDrawerActions.OpenAbout -> {
                    Log.d(TAG, "Opening About")
                }
                NavigationDrawerActions.OpenContact -> {
                    Log.d(TAG, "Opening Contacts")
                }
                NavigationDrawerActions.SignOutUser -> {
                    Log.d(TAG, "Signing Out User")
                }
            }
        }
    }

    companion object {
        private const val TAG = "NavigationDrawer"
    }
}