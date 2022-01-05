package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String, private var _size: String = "0.0", var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable {
    var size: Double = _size.toDouble()
}