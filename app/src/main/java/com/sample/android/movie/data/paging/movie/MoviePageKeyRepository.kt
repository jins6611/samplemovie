package com.sample.android.movie.data.paging.movie

import android.content.Context
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.data.network.MovieService
import com.sample.android.movie.data.paging.BaseDataSourceFactory
import com.sample.android.movie.data.paging.BasePageKeyRepository
import com.sample.android.movie.domain.model.SortType
import java.util.concurrent.Executor

class MoviePageKeyRepository(
    api: MovieService,
    sortType: SortType,
    retryExecutor: Executor,
    context: Context
) : BasePageKeyRepository<Movie>(retryExecutor) {

    override val sourceFactory: BaseDataSourceFactory<Movie> =
        MoviesDataSourceFactory(
            api = api,
            sortType = sortType,
            retryExecutor = retryExecutor,
            context = context
        )
}