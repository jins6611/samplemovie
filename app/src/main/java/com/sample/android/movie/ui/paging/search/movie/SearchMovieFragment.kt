package com.sample.android.movie.ui.paging.search.movie

import androidx.lifecycle.ViewModelProvider
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.ui.feed.NavType
import com.sample.android.movie.ui.paging.search.BaseSearchFragment
import javax.inject.Inject

class SearchMovieFragment @Inject
constructor() // Required empty public constructor
    : BaseSearchFragment<Movie>() {

    @Inject
    lateinit var factory: SearchMovieViewModel.Factory

    override val viewModel
        get() = ViewModelProvider(this, factory)[SearchMovieViewModel::class.java]

    override val navType: NavType
        get() = NavType.MOVIES
}