package com.wxxtfxrmx.wallter.photo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.wxxtfxrmx.wallter.R
import com.wxxtfxrmx.wallter.view.GlassToolbar

class PhotosFragment : Fragment(R.layout.collections_fragment) {

    companion object {
        fun newInstance(): Fragment =
            PhotosFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<GlassToolbar>(R.id.toolbar)
        toolbar.setTitle("Photos")
    }
}