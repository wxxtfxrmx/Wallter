package com.wxxtfxrmx.wallter.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import com.wxxtfxrmx.wallter.drawable.GlassDrawable
import com.wxxtfxrmx.wallter.extension.dp

class GlassCardView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : CardView(context, attributeSet, defStyleAttr) {

    private val glassDrawable = GlassDrawable(context.dp(16).toFloat())

    init {
        setLayerType(View.LAYER_TYPE_HARDWARE, null)
        background = glassDrawable
    }
}