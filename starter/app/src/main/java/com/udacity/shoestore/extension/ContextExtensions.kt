package com.udacity.shoestore.extension

import android.content.Context
import android.widget.Toast

/**
 * Created by Demir on 02-Jan-2022.
 */

fun Context.showToast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()