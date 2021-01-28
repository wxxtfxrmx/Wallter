package com.wxxtfxrmx.wallter.feature.collection

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wxxtfxrmx.wallter.R
import com.wxxtfxrmx.wallter.Router
import com.wxxtfxrmx.wallter.common.drawable.SpaceDrawable
import com.wxxtfxrmx.wallter.common.extension.dp
import com.wxxtfxrmx.wallter.common.extension.router
import com.wxxtfxrmx.wallter.common.extension.viewModels
import com.wxxtfxrmx.wallter.common.view.EmptySearchQueryState
import com.wxxtfxrmx.wallter.common.view.GlassBottomNavigationView
import com.wxxtfxrmx.wallter.common.view.GlassToolbar
import com.wxxtfxrmx.wallter.common.view.SearchInputState

class CollectionsFragment : Fragment(R.layout.collections_fragment) {

    companion object {
        fun newInstance(): Fragment =
            CollectionsFragment()
    }

    private val viewModel: CollectionsViewModel by viewModels()
    private val router: Router by router()

    private lateinit var adapter: CollectionsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val collectionList = view.findViewById<RecyclerView>(R.id.collectionList)
        collectionList.layoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }

        adapter = CollectionsAdapter(viewModel::updateCollection)
        collectionList.adapter = adapter
        collectionList.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL).also {
                it.setDrawable(SpaceDrawable(requireContext().dp(16), 0))
            }
        )

        val toolbar = view.findViewById<GlassToolbar>(R.id.toolbar)
        toolbar.setTitle("Collection")

        toolbar.setOnSearchIconClickListener {
            toolbar.state = SearchInputState
            activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        }

        toolbar.setOnCloseSearchIconClickListener {
            toolbar.state = EmptySearchQueryState
            activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        }

        toolbar.setOnStartSearchIconClickListener {
            viewModel.search(it)
            activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        }

        viewModel.collections.observe(viewLifecycleOwner) {
            adapter.collections = it
        }

        viewModel.updateCollectionEvent.observe(viewLifecycleOwner) {
            adapter.notifyDataSetChanged()
        }

        val navigation = view.findViewById<GlassBottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.collections -> Unit
                R.id.photos -> router.openPhotos()
            }

            true
        }

        viewModel.loadCollections()
    }
}