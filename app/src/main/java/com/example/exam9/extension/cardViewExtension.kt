package com.example.exam9.extension

import android.graphics.Color
import androidx.cardview.widget.CardView

fun CardView.setBackgroundColor(hexColor: String, alpha: String = "100") {
    val alphaValue = alpha.toInt() * 255 / 100
    val color = Color.parseColor(
        "#${
            alphaValue.toInt().toString(16)
        }${hexColor}"
    )
    setCardBackgroundColor(color)
}