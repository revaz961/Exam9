package com.example.exam9.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam9.databinding.CourceItemLayoutBinding
import com.example.exam9.databinding.TitleLayoutBinding
import com.example.exam9.databinding.TopicRecyclerBinding
import com.example.exam9.enum.ViewHolderType
import com.example.exam9.extension.*
import com.example.exam9.model.*

class CourceAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = mutableListOf<IViewType>()

    fun setEducation(list: List<IViewType>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewHolderType.HEADER.type -> HeaderViewHolder(
                TitleLayoutBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            ViewHolderType.TOPIC.type -> TopicViewHolder(
                TopicRecyclerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> CourseViewHolder(
                CourceItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind()
            is TopicViewHolder -> holder.bind()
            is CourseViewHolder -> holder.bind()
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) =
        when (items[position].viewType) {
            ViewHolderType.HEADER.type -> ViewHolderType.HEADER.type
            ViewHolderType.TOPIC.type -> ViewHolderType.TOPIC.type
            else -> ViewHolderType.COURCE.type
        }

    inner class TopicViewHolder(private val binding: TopicRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: TopicList
        fun bind() {
            model = items[adapterPosition] as TopicList
            binding.rvNested.adapter = TopicAdapter().apply {
                setTopic(model.topics)
            }
            binding.rvNested.layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    inner class CourseViewHolder(private val binding: CourceItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: Course
        fun bind() {
            model = items[adapterPosition] as Course
            with(binding) {
                ivImage.load(model.image)
                ivImage.setBackgroundTintColor(model.color)

                tvtitle.text = model.title
                tvSubTitle.text = model.title
                root.setBackgroundColor(model.color, model.background_color_precent)
                tvtitle.setColor(model.color)
                tvSubTitle.setColor(model.color, model.background_color_precent)

                flPlay.setBackgroundTintColor(model.color, model.background_color_precent)
                ivPlay.setTintColor(model.color)

                progress.progress = (model.precent!!.toFloat() * 100).toInt()
                progress.setIndicatorColor(model.color, model.background_color_precent)
            }

        }
    }

    inner class HeaderViewHolder(private val binding: TitleLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: Header
        fun bind() {
            model = items[adapterPosition] as Header
            binding.tvTitle.text = model.title
        }
    }
}