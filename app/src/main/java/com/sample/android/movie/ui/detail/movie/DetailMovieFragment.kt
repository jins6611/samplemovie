package com.sample.android.movie.ui.detail.movie

import androidx.lifecycle.ViewModelProvider
import com.sample.android.movie.ui.detail.DetailFragment
import javax.inject.Inject

class DetailMovieFragment @Inject
constructor() // Required empty public constructor
    : DetailFragment() {

    @Inject
    lateinit var factory: DetailMovieViewModel.Factory

    override val viewModel
        get() = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]
}