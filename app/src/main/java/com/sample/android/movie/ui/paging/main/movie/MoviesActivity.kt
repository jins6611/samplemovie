package com.sample.android.movie.ui.paging.main.movie

import com.sample.android.movie.R
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.ui.feed.NavType
import com.sample.android.movie.ui.paging.main.MainActivity

abstract class MoviesActivity: MainActivity<Movie>() {

    protected abstract val titleId: Int

    override val screenTitle: String
        get() = getString(titleId, getString(R.string.menu_movies))

    override val navType: NavType
        get() = NavType.MOVIES
}