package com.wxxtfxrmx.wallter.preview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.wxxtfxrmx.wallter.R

class PreviewView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : ConstraintLayout(context, attrSet, defStyleAttr, defStyleRes) {

    init {
        inflate(context, R.layout.collection_view_holder, this)
        setBackgroundColor(Color.CYAN)
    }
}