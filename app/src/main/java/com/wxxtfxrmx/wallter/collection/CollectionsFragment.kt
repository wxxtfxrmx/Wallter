package com.wxxtfxrmx.wallter.collection

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wxxtfxrmx.wallter.R
import com.wxxtfxrmx.wallter.Router
import com.wxxtfxrmx.wallter.drawable.SpaceDrawable
import com.wxxtfxrmx.wallter.extension.dp
import com.wxxtfxrmx.wallter.extension.router
import com.wxxtfxrmx.wallter.extension.viewModels
import com.wxxtfxrmx.wallter.view.EmptySearchQueryState
import com.wxxtfxrmx.wallter.view.GlassBottomNavigationView
import com.wxxtfxrmx.wallter.view.GlassToolbar
import com.wxxtfxrmx.wallter.view.SearchInputState

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

        adapter = CollectionsAdapter()
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