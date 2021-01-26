package com.wxxtfxrmx.wallter.collection

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wxxtfxrmx.wallter.R
import com.wxxtfxrmx.wallter.drawable.SpaceDrawable
import com.wxxtfxrmx.wallter.extension.dp
import com.wxxtfxrmx.wallter.extension.viewModels

class CollectionsFragment : Fragment(R.layout.collections_fragment) {

    companion object {
        fun newInstance(): Fragment =
            CollectionsFragment()
    }

    private val viewModel: CollectionsViewModel by viewModels()
    private val adapter = CollectionsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val collectionList = view.findViewById<RecyclerView>(R.id.collectionList)
        collectionList.layoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }

        collectionList.adapter = adapter
        collectionList.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL).also {
                it.setDrawable(SpaceDrawable(requireContext().dp(16), 0))
            }
        )

        viewModel.collections.observe(viewLifecycleOwner) {
            adapter.collections = it
        }

        viewModel.loadCollections()
    }
}