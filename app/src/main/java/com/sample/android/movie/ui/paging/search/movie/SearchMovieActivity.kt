package com.sample.android.movie.ui.paging.search.movie

import com.sample.android.movie.R
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.ui.paging.search.SearchActivity
import javax.inject.Inject

class SearchMovieActivity: SearchActivity<Movie>() {

    @Inject
    lateinit var searchMovieFragment: SearchMovieFragment

    override val fragment: SearchMovieFragment
        get() = searchMovieFragment

    override val hintId: Int
        get() = R.string.menu_movies
}