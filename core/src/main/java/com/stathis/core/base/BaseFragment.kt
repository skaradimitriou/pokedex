package com.stathis.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding>(private val layoutId: Int) : Fragment() {

    lateinit var binding: VB

    abstract fun init()
    abstract fun startOps()
    abstract fun stopOps()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = LayoutInflater.from(requireContext()).inflate(layoutId, container, false)
        binding = DataBindingUtil.bind(viewRoot)!!
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()
        startOps()
    }

    override fun onStop() {
        stopOps()
        binding.unbind()
        super.onStop()
    }
}