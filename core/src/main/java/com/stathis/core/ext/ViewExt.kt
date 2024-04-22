package com.stathis.core.ext

import androidx.fragment.app.Fragment

fun Fragment.setScreenTitle(title: String) {
    requireActivity().title = title
}