package com.example.exam9.extension

import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.FrameLayout

fun FrameLayout.setBackgroundTintColor(hexColor: String, alpha: String = "100") {
    val alphaValue = alpha.toInt() * 255 / 100
    val color = Color.parseColor(
        "#${
            alphaValue.toInt().toString(16)
        }${hexColor}"
    )
    backgroundTintList = ColorStateList.valueOf(color)
}