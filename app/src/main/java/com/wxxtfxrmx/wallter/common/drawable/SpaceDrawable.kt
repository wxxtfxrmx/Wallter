package com.wxxtfxrmx.wallter.common.drawable

import android.graphics.drawable.ColorDrawable

class SpaceDrawable(private val width: Int, private val height: Int) : ColorDrawable() {

    override fun getIntrinsicWidth(): Int =
        width

    override fun getIntrinsicHeight(): Int =
        height
}