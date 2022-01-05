package com.udacity.shoestore.ui.shoeDetail

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.ui.shoeList.ShoeListViewModel

class ShoeDetailFragment : BaseFragment<ShoeDetailFragmentBinding>(R.layout.shoe_detail_fragment) {

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun populateUi() {
        mBinding.shoeListViewModel= shoeListViewModel
        shoeListViewModel.isCloseScreen.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigateUp()
            }
        })
    }

}