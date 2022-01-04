package com.udacity.shoestore.ui.onboarding

import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.OnboardingFragmentBinding

class OnboardingFragment : BaseFragment<OnboardingFragmentBinding>(R.layout.onboarding_fragment) {

    override fun populateUi() {
        mBinding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_guideFragment)
        }
    }
}