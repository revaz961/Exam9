package com.example.exam9.ui.Course

import com.example.exam9.databinding.CourcesFragmentBinding
import com.example.exam9.ui.BaseFragment

class CourcesFragment : BaseFragment<CourcesFragmentBinding, CourcesViewModel>(
    CourcesFragmentBinding::inflate,
    CourcesViewModel::class.java
) {

    override fun start() {
        init()
    }

    private fun init(){

    }


}