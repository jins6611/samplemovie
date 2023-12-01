package com.sample.android.movie.ui.paging.search

import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.data.paging.Status.RUNNING
import com.sample.android.movie.ui.paging.BaseFragment
import com.sample.android.movie.util.toVisibility

abstract class BaseSearchFragment<T : TmdbItem> : BaseFragment<T>() {

    private val searchViewModel
        get() = viewModel as BaseSearchViewModel

    override fun refresh() {
        super.refresh()
        searchViewModel.refreshState.removeObservers(this)
    }

    fun search(query: String) {
        if (searchViewModel.showQuery(query)) {
            binding.recyclerView.scrollToPosition(0)
            tmdbAdapter.submitList(null)
        }
    }

    fun observeRefreshState() {
        searchViewModel.refreshState.observe(this) {
            binding.recyclerView.toVisibility(it.status != RUNNING)
        }
    }
}