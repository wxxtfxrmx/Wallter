package com.wxxtfxrmx.wallter.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.wxxtfxrmx.wallter.R
import com.wxxtfxrmx.wallter.drawable.GlassDrawable
import com.wxxtfxrmx.wallter.extension.dp
import kotlin.math.hypot

class GlassToolbar @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialToolbar(context, attributeSet, defStyleAttr) {

    private val glass = GlassDrawable(context.dp(8).toFloat())

    private val title: TextView
    private val searchIcon: ImageView

    private val searchLayout: TextInputLayout
    private val searchInput: TextInputEditText
    private var onCloseSearchClickListener: (() -> Unit)? = null
    private var onAddSearchClickListener: ((String) -> Unit)? = null


    var state: ToolbarState = EmptySearchQueryState
        set(value) {
            field = value
            applyState(value)
        }

    init {
        inflate(context, R.layout.toolbar_search_layout, this)

        title = findViewById(R.id.title)
        searchIcon = findViewById(R.id.searchIcon)

        searchLayout = findViewById(R.id.searchLayout)
        searchInput = findViewById(R.id.searchInput)
        searchInput.background = glass


        searchInput.addTextChangedListener(afterTextChanged = {
            val text = it?.toString()
            if (!text.isNullOrBlank()) {
                searchLayout.setEndIconDrawable(R.drawable.ic_next)
            } else {
                searchLayout.setEndIconDrawable(R.drawable.ic_cross)
            }
        })

        searchLayout.setEndIconOnClickListener {
            val text = searchInput.text?.toString()
            if (text.isNullOrBlank()) {
                onCloseSearchClickListener?.invoke()
            } else {
                onAddSearchClickListener?.invoke(text)
            }
        }
    }

    fun setOnSearchIconClickListener(listener: () -> Unit) {
        searchIcon.setOnClickListener { listener() }
    }

    fun setOnCloseSearchIconClickListener(listener: () -> Unit) {
        onCloseSearchClickListener = listener
    }

    fun setOnStartSearchIconClickListener(listener: (String) -> Unit) {
        onAddSearchClickListener = listener
    }

    fun setTitle(title: String) {
        this.title.text = title
    }

    private fun applyState(toolbarState: ToolbarState) {
        when (toolbarState) {
            EmptySearchQueryState -> {
                title.reveal()
                searchIcon.isVisible = true
                searchLayout.isVisible = false
            }

            SearchInputState -> {
                searchLayout.reveal()
                title.isVisible = false
                searchIcon.isVisible = false
                searchInput.requestFocus()
            }
        }
    }

    private fun View.reveal() {
        val cx = width
        val cy = height / 2

        val radius = hypot(cx.toDouble(), cy.toDouble()).toFloat()
        val animation = ViewAnimationUtils.createCircularReveal(this, cx, cy, 0f, radius)
        isVisible = true
        animation.start()
    }
}

sealed class ToolbarState
object EmptySearchQueryState : ToolbarState()
object SearchInputState : ToolbarState()