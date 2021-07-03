package com.example.exam9.extension

import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.exam9.R

fun ImageView.load(
    url: String?,
    placeholder: Int = R.drawable.image_not_found,
    error: Int = R.drawable.image_not_found
) {
    Glide.with(this.context)
        .load(url ?: "")
        .placeholder(placeholder)
        .error(error)
        .into(this);
}

fun ImageView.setBackgroundTintColor(hexColor: String, alpha: String = "100") {
    val alphaValue = alpha.toInt() * 255 / 100
    val color = Color.parseColor(
        "#${
            alphaValue.toInt().toString(16)
        }${hexColor}"
    )
    backgroundTintList = ColorStateList.valueOf(color)
}

fun ImageView.setTintColor(hexColor: String, alpha: String = "100") {
    val alphaValue = alpha.toInt() * 255 / 100
    val color = Color.parseColor(
        "#${
            alphaValue.toInt().toString(16)
        }${hexColor}"
    )
    imageTintList = ColorStateList.valueOf(color)
}