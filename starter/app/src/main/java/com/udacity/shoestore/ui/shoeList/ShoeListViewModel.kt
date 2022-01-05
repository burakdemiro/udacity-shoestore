package com.udacity.shoestore.ui.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _isCloseScreen = MutableLiveData<Boolean>()
    val isCloseScreen: LiveData<Boolean>
            get() = _isCloseScreen

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = getMockShoeList()
    }

    private fun getMockShoeList(): List<Shoe> {
        val mockShoes = mutableListOf<Shoe>()

        mockShoes.add(Shoe("Superstar", "39.0", "Nike", "Iconic Rubber Toe"))
        mockShoes.add(Shoe("Boost", "41.0", "Adidas", "Built for performance"))
        mockShoes.add(Shoe("Energy", "34.0", "Kinetix", "For kids faster than light"))

        return mockShoes
    }

    fun save(name: String, company: String, size: String, description: String) {
        val tempShoes = mutableListOf<Shoe>()

        _shoeList.value?.let {
            tempShoes.addAll(it)
        }

        tempShoes.add(Shoe(name, size, company, description))

        _shoeList.value = tempShoes
        _isCloseScreen.value = true
        _isCloseScreen.value = false
    }
}