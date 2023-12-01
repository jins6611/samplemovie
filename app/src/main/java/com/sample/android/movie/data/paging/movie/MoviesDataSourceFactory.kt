package com.sample.android.movie.data.paging.movie

import android.content.Context
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.data.network.MovieService
import com.sample.android.movie.data.paging.BaseDataSourceFactory
import com.sample.android.movie.data.paging.BasePageKeyedDataSource
import com.sample.android.movie.domain.model.SortType
import java.util.concurrent.Executor

class MoviesDataSourceFactory(
    private val api: MovieService,
    private val sortType: SortType,
    private val retryExecutor: Executor,
    private val context: Context
) : BaseDataSourceFactory<Movie>() {

    override val dataSource: BasePageKeyedDataSource<Movie>
        get() = MoviePageKeyedDataSource(
            api = api,
            sortType = sortType,
            retryExecutor = retryExecutor,
            context = context
        )
}
