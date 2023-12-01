package com.sample.android.movie.ui.paging.main.movie

import com.sample.android.movie.domain.model.SortType.MOST_POPULAR
import javax.inject.Inject

class PopularMoviesFragment @Inject
constructor() : MovieFragment() {

    override val sortType = MOST_POPULAR
}