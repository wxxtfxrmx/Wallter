package com.wxxtfxrmx.wallter.common.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.wxxtfxrmx.wallter.MainActivity
import com.wxxtfxrmx.wallter.Router
import kotlin.properties.ReadOnlyProperty

inline fun <reified T : ViewModel> Fragment.viewModels(): ReadOnlyProperty<ViewModelStoreOwner, T> =
    ReadOnlyProperty { owner, _ ->
        val factory = (activity as MainActivity).viewModelProviderFactory
        ViewModelProvider(owner, factory)[T::class.java]
    }

fun Fragment.router(): ReadOnlyProperty<Any?, Router> =
    ReadOnlyProperty { _, _ -> activity as Router }