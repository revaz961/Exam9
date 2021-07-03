package com.example.exam9.ui.Course

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam9.adapter.CourceAdapter
import com.example.exam9.databinding.CourcesFragmentBinding
import com.example.exam9.model.Header
import com.example.exam9.model.IViewType
import com.example.exam9.model.TopicList
import com.example.exam9.ui.BaseFragment

class CourcesFragment : BaseFragment<CourcesFragmentBinding, CourcesViewModel>(
    CourcesFragmentBinding::inflate,
    CourcesViewModel::class.java
) {

    private lateinit var adapter:CourceAdapter

    override fun start() {
        init()
    }

    private fun init() {
        observes()
        initRecycler()
    }

    private fun initRecycler() {
        adapter = CourceAdapter()
        binding.rvCources.adapter = adapter
        binding.rvCources.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getEducation()
    }

    private fun observes(){
        viewModel.liveData.observe(viewLifecycleOwner,{
            val list = mutableListOf<IViewType>().apply {
                add(Header())
                add(TopicList(it.topic))
                addAll(it.courses)
            }
            adapter.setEducation(list)
        })
    }

}