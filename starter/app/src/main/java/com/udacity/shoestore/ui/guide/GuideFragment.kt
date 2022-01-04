package com.udacity.shoestore.ui.guide

import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentGuideBinding

class GuideFragment : BaseFragment<FragmentGuideBinding>(R.layout.fragment_guide) {

    override fun populateUi() {
        mBinding.buttonStart.setOnClickListener {
            findNavController().navigate(GuideFragmentDirections.actionGuideFragmentToShoeListFragment())
        }
    }
}