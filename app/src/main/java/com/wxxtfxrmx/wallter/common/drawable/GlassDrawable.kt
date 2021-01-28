package com.wxxtfxrmx.wallter.common.drawable

import android.graphics.Color
import android.graphics.drawable.GradientDrawable

class GlassDrawable(corners: Float) : GradientDrawable() {

    private val topLeft = Color.argb(0.3f, 1f, 1f, 1f)
    private val bottomRight = Color.argb(0.2f, 1f, 1f, 1f)
    private val bottomRight2 = Color.argb(0.1f, 1f, 1f, 1f)

    init {
        orientation = Orientation.TL_BR
        colors = intArrayOf(topLeft, bottomRight, bottomRight2)
        cornerRadius = corners
    }
}