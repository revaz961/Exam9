package com.example.exam9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam9.R
import com.example.exam9.databinding.TopicLayoutBinding
import com.example.exam9.extension.setBackgroundColor
import com.example.exam9.extension.setTintColor
import com.example.exam9.model.Topic

class TopicAdapter : RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    private val topics = mutableListOf<Topic>()

    fun setTopic(list: List<Topic>) {
        topics.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        return TopicViewHolder(
            TopicLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = topics.size


    inner class TopicViewHolder(private val binding: TopicLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: Topic
        fun bind() {
            model = topics[adapterPosition]
            with(binding) {
                ivType.setImageResource(
                    if (model.type == "free")
                        R.drawable.ic_settings
                    else
                        R.drawable.ic_card
                )
                tvTitle.text = model.title
                tvDuration.text = "${model.duration} min"
                root.setBackgroundColor(model.color!!)
                ivPlay.setTintColor(model.color!!)
            }
        }
    }
}