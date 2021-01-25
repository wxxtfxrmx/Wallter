package com.wxxtfxrmx.wallter.view

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class GlassButton @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatButton(context, attributeSet, defStyleAttr) {

    private val glassColor = Color.argb(0.3f, 1f, 1f, 1f)
    private val glass = GradientDrawable().apply {
        setColor(glassColor)
        cornerRadius = 8f
    }
    private val ripple = RippleDrawable(
        ColorStateList.valueOf(0x20_000000),
        glass,
        null
    )

    init {
        background = ripple
    }
}