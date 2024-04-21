package com.stathis.pokedex.navigator

import android.os.Bundle

interface Navigator {

    fun navigateTo(screenKey: NavAction, args: Bundle? = null)
    fun goBack()
}