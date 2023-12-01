package com.sample.android.movie.ui.paging.main.movie

import com.sample.android.movie.R
import javax.inject.Inject

class PopularMoviesActivity: MoviesActivity() {

    @Inject
    lateinit var popularMoviesFragment: PopularMoviesFragment

    override val titleId: Int
        get() = R.string.popular

    override val fragment: MovieFragment
        get() = popularMoviesFragment
}