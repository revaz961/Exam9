package com.example.exam9.model

import com.example.exam9.enum.ViewHolderType

data class TopicList(
    val topics: List<Topic>
) : IViewType{
    override val viewType: Int
        get() = ViewHolderType.TOPIC.type
}
