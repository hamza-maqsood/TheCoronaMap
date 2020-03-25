package com.grayhatdevelopers.thecoronamap.ui.fragments.report

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.grayhatdevelopers.thecoronamap.R
import com.grayhatdevelopers.thecoronamap.databinding.FragmentReportBinding
import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseFragment
import com.grayhatdevelopers.thecoronamap.utils.InjectorUtils
import com.mapbox.mapboxsdk.maps.Style

class ReportFragment : BaseFragment() {

    private lateinit var mViewModel: ReportViewModel
    private lateinit var fragmentReportBinding: FragmentReportBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentReportBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_report,
            container,
            false
        )
        fragmentReportBinding.apply {
            lifecycleOwner = this@ReportFragment
            mViewModel = InjectorUtils.provideReportViewModel()
            viewModel = mViewModel
        }
        return fragmentReportBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initMapView(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeReportFragmentActions()
    }

    private fun observeReportFragmentActions() {
        mViewModel.reportFragmentActions.observe(viewLifecycleOwner) {
            when (it) {
                ReportFragmentActions.GoBack -> {
                    Log.d(TAG, "Going Back")
                    baseViewModel.popBack()
                }
            }
        }
    }

    private fun initMapView(savedInstanceState: Bundle?) {
        fragmentReportBinding.mapView.onCreate(savedInstanceState)
        fragmentReportBinding.mapView.getMapAsync { mapboxMap ->
            var lastZoom = mapboxMap.cameraPosition.zoom
            mapboxMap.setStyle(Style.MAPBOX_STREETS) {
                // Map is set up and the style has loaded. Now you can add data or make other map adjustments.
                // todo add task location points
            }
            fragmentReportBinding.mapView.addOnCameraDidChangeListener {
//                if (it) {
                val currentZoom = mapboxMap.cameraPosition.zoom
                if (currentZoom < lastZoom) {
                    // zoom in
//                        context?.toast("I'm zoom in")
                    Log.d("ZoomZoom", "ZoomZOom")
                }
                lastZoom = currentZoom
//                    Log.d("ZoomZoom", "Current zoom: $currentZoom -- lastZoom: $lastZoom")
            }
//            }
        }
    }

    // Add the mapView lifecycle to the activity's lifecycle methods
    override fun onResume() {
        super.onResume()
        fragmentReportBinding.mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        fragmentReportBinding.mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        fragmentReportBinding.mapView.onStop()
    }

    override fun onPause() {
        super.onPause()
        fragmentReportBinding.mapView.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        fragmentReportBinding.mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentReportBinding.mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        fragmentReportBinding.mapView.onSaveInstanceState(outState)
    }

    companion object {
        private const val TAG = "ReportFragment"
    }
}