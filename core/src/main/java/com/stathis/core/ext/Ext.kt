package com.stathis.core.ext

import androidx.appcompat.widget.SearchView

fun SearchView.onQueryTextSubmit(closure: (String) -> Unit) {
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            closure.invoke(query.toString())
            clearFocus()
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }
    })
}