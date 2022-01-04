package com.udacity.shoestore.ui.shoeList

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : BaseFragment<ShoeListFragmentBinding>(R.layout.shoe_list_fragment) {

    private val mViewModel: ShoeListViewModel by activityViewModels()

    override fun populateUi() {
        setHasOptionsMenu(true)

        mViewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            shoeList?.let {
                showShoeList(it)
            }
        }

        mBinding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
    }

    private fun showShoeList(shoeList: List<Shoe>) {
        shoeList.forEach {
            createShoe(it)
        }
    }

    private fun createShoe(shoe: Shoe) {
        val itemShoeBinding = DataBindingUtil.inflate<ItemShoeBinding>(layoutInflater, R.layout.item_shoe, null, false)
            .apply {
                tvName.text = getString(R.string.string_value, "Shoe name:", shoe.name)
                tvCompanyName.text = getString(R.string.string_value, "Company name:", shoe.company)
                tvSize.text = getString(R.string.double_value, "Shoe size:", shoe.size)
                tvDescription.text =
                    getString(R.string.string_value, "Description:", shoe.description)
            }.root
        mBinding.linearLayout.addView(itemShoeBinding)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_shoe_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            findNavController()
        ) || super.onOptionsItemSelected(item)
    }

}