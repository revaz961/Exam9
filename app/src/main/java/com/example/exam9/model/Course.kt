package com.example.exam9.model

import com.example.exam9.enum.ViewHolderType

data class Course(
    val title: String?,
    val precent: String?,
    val image: String?,
    val color: String,
    val background_color_precent: String
):IViewType{
    override val viewType: Int
    get() =
        ViewHolderType.COURCE.type
}
