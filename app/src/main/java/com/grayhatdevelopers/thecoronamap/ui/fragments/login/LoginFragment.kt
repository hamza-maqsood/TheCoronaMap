package com.grayhatdevelopers.thecoronamap.ui.fragments.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.grayhatdevelopers.thecoronamap.databinding.FragmentLoginOptionsBinding
import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseFragment
import com.grayhatdevelopers.thecoronamap.utils.InjectorUtils

class LoginFragment : BaseFragment() {

    private lateinit var mViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentLoginOptionsBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            lifecycleOwner = this@LoginFragment
            mViewModel = InjectorUtils.provideLoginViewModel()
            viewModel = mViewModel
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeLoginActions()
    }

    private fun observeLoginActions() {
        mViewModel.loginActions.observe(viewLifecycleOwner) {
            when (it) {
                LoginActions.LoginWithPhoneNumber -> {
                    Log.d(TAG, "LoginWithPhoneNumber clicked")
                }
                LoginActions.LoginWithFacebook -> {
                    Log.d(TAG, "LoginWithFacebook clicked")
                }
                LoginActions.LoginWithGoogle -> {
                    Log.d(TAG, "LoginWithGoogle clicked")
                }
                LoginActions.Proceed -> {
                    Log.d(TAG, "Proceed clicked")
                    baseViewModel.navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
                }
            }
        }
    }

    companion object {
        private const val TAG = "LoginFragment"
    }
}