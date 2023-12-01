package com.sample.android.movie.ui.base

import android.content.Intent
import android.os.Bundle
import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.ui.detail.movie.DetailMovieActivity
import com.sample.android.movie.ui.feed.NavType
import com.sample.android.movie.util.Constants
import dagger.android.support.DaggerFragment

abstract class BaseNavTypeFragment : DaggerFragment()  {

    protected abstract val navType: NavType

    protected fun startDetailActivity(tmdbItem: TmdbItem) {
        val activityClass = when (navType) {
            NavType.MOVIES -> DetailMovieActivity::class.java
            else -> throw RuntimeException("Unknown item to start detail Activity")
        }
        val intent = Intent(requireActivity(), activityClass).apply {
            putExtras(Bundle().apply {
                putParcelable(Constants.EXTRA_TMDB_ITEM, tmdbItem)
            })
        }
        startActivity(intent)
    }
}