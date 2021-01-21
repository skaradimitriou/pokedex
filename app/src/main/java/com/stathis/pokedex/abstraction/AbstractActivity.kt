package com.stathis.pokedex.abstraction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class AbstractActivity(layoutId : Int) : AppCompatActivity(layoutId) {

    abstract fun init()
    abstract fun running()
    abstract fun stopped()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        init()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPostResume() {
        super.onPostResume()
        running()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        stopped()
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}