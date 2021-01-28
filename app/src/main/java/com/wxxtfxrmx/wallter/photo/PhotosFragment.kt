package com.wxxtfxrmx.wallter.photo

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

class PhotosFragment : Fragment(R.layout.photos_fragment) {

    companion object {
        fun newInstance(): Fragment =
            PhotosFragment()
    }

    private val viewModel: PhotosViewModel by viewModels()
    private val router: Router by router()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<GlassToolbar>(R.id.toolbar)
        toolbar.setTitle("Photos")

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

        val adapter = PhotosAdapter()
        val photosList = view.findViewById<RecyclerView>(R.id.photosList)
        photosList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        photosList.adapter = adapter
        photosList.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL).apply {
                setDrawable(SpaceDrawable(0, requireContext().dp(16)))
            }
        )

        viewModel.photos.observe(viewLifecycleOwner) {
            adapter.photos = it
        }

        val navigation = view.findViewById<GlassBottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.photos -> Unit
                R.id.collections -> router.openCollections()
            }

            true
        }

        viewModel.loadPhotos()
    }
}