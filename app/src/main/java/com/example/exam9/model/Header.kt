package com.example.exam9.model

import com.example.exam9.enum.ViewHolderType

data class Header(
    val title: String = "Cources"
) : IViewType {
    override val viewType: Int
        get() = ViewHolderType.HEADER.type
}