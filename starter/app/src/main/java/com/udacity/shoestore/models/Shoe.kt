package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String, private var _size: String, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable {
    var size: Double = if (_size.isNotBlank()) _size.toDouble() else 0.0
}