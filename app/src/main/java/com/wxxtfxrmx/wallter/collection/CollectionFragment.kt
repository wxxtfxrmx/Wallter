package com.wxxtfxrmx.wallter.collection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wxxtfxrmx.wallter.R
import com.wxxtfxrmx.wallter.drawable.SpaceDrawable

class CollectionFragment : Fragment(R.layout.collection_fragment) {

    companion object {
        fun newInstance(): Fragment =
            CollectionFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val collectionList = view.findViewById<RecyclerView>(R.id.collectionList)
        collectionList.layoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }

        collectionList.adapter = CollectionAdapter()
        collectionList.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL).also {
                it.setDrawable(SpaceDrawable(16, 0))
            }
        )
    }
}