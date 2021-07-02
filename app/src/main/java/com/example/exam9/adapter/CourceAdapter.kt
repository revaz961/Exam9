package com.example.exam9.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam9.databinding.CourcesFragmentBinding
import com.example.exam9.databinding.TopicLayoutBinding
import com.example.exam9.model.Course
import com.example.exam9.model.Education

class CourceAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object{
        const val TOPYC_TYPE = 1
        const val COURSE_TYPE = 2
    }

    private var education: Education? = null

    fun setCourse(education:Education){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int) =
        when(position){

        }

    inner class TopicViewHolder(private val binding: TopicLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(){

        }
    }

    inner class CourceViewHolder(private val binding: CourcesFragmentBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(){

        }
    }
}