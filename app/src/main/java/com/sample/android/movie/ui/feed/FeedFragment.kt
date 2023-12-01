package com.sample.android.movie.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.ui.base.BaseNavTypeFragment
import com.sample.android.movie.ui.common.Content
import com.sample.android.movie.ui.common.TmdbTheme
import com.sample.android.movie.ui.common.composeView

abstract class FeedFragment<T : TmdbItem> : BaseNavTypeFragment() {

    protected abstract val viewModel: FeedViewModel<T>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composeView {
        TmdbTheme {
            Content(viewModel) {
                FeedCollectionList(
                    navType,
                    it
                ) { tmdbItem ->
                    startDetailActivity(tmdbItem)
                }
            }
        }
    }
}