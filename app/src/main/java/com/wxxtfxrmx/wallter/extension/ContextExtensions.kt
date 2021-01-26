package com.wxxtfxrmx.wallter.extension

import android.content.Context
import android.util.TypedValue

fun Context.dp(px: Int): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px.toFloat(), resources.displayMetrics).toInt()