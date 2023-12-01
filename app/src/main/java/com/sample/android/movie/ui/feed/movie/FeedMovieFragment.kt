package com.sample.android.movie.ui.feed.movie

import androidx.lifecycle.ViewModelProvider
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.ui.feed.FeedFragment
import com.sample.android.movie.ui.feed.NavType
import javax.inject.Inject

class FeedMovieFragment @Inject
constructor() // Required empty public constructor
    : FeedFragment<Movie>() {

    @Inject
    lateinit var factory: FeedMovieViewModel.Factory

    override val viewModel
        get() = ViewModelProvider(this, factory)[FeedMovieViewModel::class.java]

    override val navType: NavType
        get() = NavType.MOVIES
}