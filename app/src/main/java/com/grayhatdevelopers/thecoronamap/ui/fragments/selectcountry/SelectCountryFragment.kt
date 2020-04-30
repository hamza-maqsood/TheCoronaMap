package com.grayhatdevelopers.thecoronamap.ui.fragments.selectcountry

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.grayhatdevelopers.thecoronamap.databinding.FragmentSelectCountryBinding
import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseFragment
import com.grayhatdevelopers.thecoronamap.utils.InjectorUtils

class SelectCountryFragment : BaseFragment() {

    private lateinit var mViewModel: SelectCountryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSelectCountryBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            lifecycleOwner = this@SelectCountryFragment
            mViewModel = InjectorUtils.provideSelectLanguageViewModel()
            viewModel = mViewModel
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel.selectCountryActions.observe(viewLifecycleOwner) {
            when (it) {
                SelectCountryActions.Continue -> {
                    Log.d(TAG, "Continuing to Login Fragment")
                    baseViewModel.navigate(SelectCountryFragmentDirections.actionSelectCountryFragmentToLoginFragment())
                }
            }
        }
    }

    companion object {
        private const val TAG = "SelectCountryFragment"
    }
}
