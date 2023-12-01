package com.sample.android.movie.ui.paging.main.movie

import com.sample.android.movie.domain.model.SortType
import javax.inject.Inject

class TrendingMoviesFragment @Inject
constructor() : MovieFragment() {

    override val sortType = SortType.TRENDING
}