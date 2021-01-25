package com.wxxtfxrmx.wallter.drawable

import android.graphics.Color
import android.graphics.drawable.GradientDrawable

class GlassDrawable : GradientDrawable() {

    private val topLeft = Color.argb(0.3f, 1f, 1f, 1f)
    private val bottomRight = Color.argb(0.1f, 1f, 1f, 1f)

    init {
        orientation = Orientation.TL_BR
        colors = intArrayOf(topLeft, bottomRight)
        cornerRadius = 8f
    }
}