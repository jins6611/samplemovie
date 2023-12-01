package com.sample.android.movie.ui.paging.main.movie

import android.app.Application
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.data.network.MovieService
import com.sample.android.movie.data.paging.BasePageKeyRepository
import com.sample.android.movie.data.paging.movie.MoviePageKeyRepository
import com.sample.android.movie.ui.paging.main.BaseItemViewModel
import com.sample.android.movie.domain.model.SortType

class MovieViewModel(
    api: MovieService,
    sortType: SortType,
    app: Application
) : BaseItemViewModel<Movie>(app = app) {

    override val mainRepoResult: BasePageKeyRepository<Movie> = MoviePageKeyRepository(api = api,
            sortType = sortType,
            retryExecutor = networkIO,
            context = app.applicationContext)
}