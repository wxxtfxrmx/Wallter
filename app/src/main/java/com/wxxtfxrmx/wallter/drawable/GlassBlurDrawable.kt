package com.wxxtfxrmx.wallter.drawable

import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.core.graphics.toRectF

class GlassBlurDrawable : Drawable() {

    private val bottomRight = Color.argb(0.4f, 1f, 1f, 1f)

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = bottomRight
        maskFilter = BlurMaskFilter(48f, BlurMaskFilter.Blur.INNER)
    }

    override fun draw(canvas: Canvas) {
        canvas.drawRoundRect(
            bounds.toRectF(),
            8f,
            8f,
            paint
        )
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int =
        PixelFormat.TRANSLUCENT
}