package com.udacity.shoestore.ui.login

import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.LoginFragmentBinding
import com.udacity.shoestore.extension.showToast

class LoginFragment : BaseFragment<LoginFragmentBinding>(R.layout.login_fragment) {

    private val onboardingDirection = LoginFragmentDirections.actionLoginFragmentToOnboardingFragment()

    override fun populateUi() {
        with(mBinding) {
            buttonLogin.setOnClickListener {
                login()
            }

            buttonCreateAcc.setOnClickListener {
                createAccount()
            }
        }
    }

    private fun login() {
        with(mBinding) {
            val username = edittextUsername.text
            val password = edittextPassword.text

            if (!username.isNullOrBlank()
                && !password.isNullOrBlank()
            ) {
                findNavController().navigate(onboardingDirection)

            } else {
                requireContext().showToast(getString(R.string.login_error))
            }
        }
    }

    private fun createAccount() {
        findNavController().navigate(onboardingDirection)
    }
}