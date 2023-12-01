package com.sample.android.movie.ui.paging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.sample.android.movie.R
import com.sample.android.movie.databinding.FragmentMainBinding
import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.data.paging.Status.RUNNING
import com.sample.android.movie.ui.base.BaseNavTypeFragment
import com.sample.android.movie.widget.MarginDecoration

abstract class BaseFragment<T : TmdbItem> : BaseNavTypeFragment() {

    protected abstract val viewModel: BasePagingViewModel<T>

    private var _binding: FragmentMainBinding? = null

    protected val binding get() = _binding!!

    protected lateinit var tmdbAdapter: TmdbAdapter<T>

    protected open fun refresh() {
        viewModel.refresh()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater)

        tmdbAdapter = TmdbAdapter(viewModel::retry, object : TmdbClickCallback<T> {
            override fun onClick(t: T) {
                startDetailActivity(t)
            }
        })

        with(binding) {

            swipeRefresh.apply {
                setColorSchemeColors(
                    ContextCompat.getColor(context, R.color.colorPrimary),
                    ContextCompat.getColor(context, R.color.colorAccent),
                    ContextCompat.getColor(context, R.color.colorPrimaryDark)
                )

                viewModel.refreshState.observe(viewLifecycleOwner) {
                    isRefreshing = it.status == RUNNING
                }

                setOnRefreshListener { refresh() }
            }

            recyclerView.apply {
                addItemDecoration(MarginDecoration(context))
                setHasFixedSize(true)
                adapter = tmdbAdapter
                manager.spanSizeLookup = object : SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (tmdbAdapter.getItemViewType(position) == R.layout.tmdb_item)
                            1 else manager.spanCount
                    }
                }
            }
        }

        viewModel.items.observe(viewLifecycleOwner) {
            tmdbAdapter.submitList(it)
        }

        viewModel.networkState.observe(viewLifecycleOwner) {
            tmdbAdapter.setNetworkState(it)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}