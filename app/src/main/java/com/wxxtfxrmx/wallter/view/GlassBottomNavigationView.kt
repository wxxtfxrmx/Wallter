package com.wxxtfxrmx.wallter.view

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wxxtfxrmx.wallter.drawable.GlassBlurDrawable

class GlassBottomNavigationView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : BottomNavigationView(context, attributeSet, defStyleAttr) {

    private val glass = GlassBlurDrawable()

    init {
        background = glass
    }
}