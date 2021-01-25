package com.wxxtfxrmx.wallter.view

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.wxxtfxrmx.wallter.drawable.GlassBlurDrawable

class GlassCardView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : CardView(context, attributeSet, defStyleAttr) {

    private val glassDrawable = GlassBlurDrawable()

    init {
        background = glassDrawable

    }
}