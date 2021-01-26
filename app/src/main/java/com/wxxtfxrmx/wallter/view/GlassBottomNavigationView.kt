package com.wxxtfxrmx.wallter.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wxxtfxrmx.wallter.drawable.GlassBlurDrawable
import com.wxxtfxrmx.wallter.drawable.GlassDrawable
import com.wxxtfxrmx.wallter.extension.dp

class GlassBottomNavigationView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : BottomNavigationView(context, attributeSet, defStyleAttr) {

    private val glass = GlassDrawable(context.dp(16).toFloat())

    init {
        background = glass
    }
}