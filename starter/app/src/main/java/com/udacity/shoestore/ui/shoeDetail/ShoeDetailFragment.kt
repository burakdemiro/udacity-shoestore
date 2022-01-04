package com.udacity.shoestore.ui.shoeDetail

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.ui.shoeList.ShoeListViewModel

class ShoeDetailFragment : BaseFragment<ShoeDetailFragmentBinding>(R.layout.shoe_detail_fragment) {

    private val mViewModel: ShoeListViewModel by activityViewModels()

    override fun populateUi() {
        mBinding.shoeListViewModel = mViewModel

        mBinding.buttonSave.setOnClickListener {
            mViewModel.save()
        }

        mViewModel.isCloseScreen.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigateUp()
            }
        })
    }

}