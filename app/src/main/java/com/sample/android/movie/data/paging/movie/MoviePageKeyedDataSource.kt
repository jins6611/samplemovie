package com.sample.android.movie.data.paging.movie

import android.content.Context
import com.sample.android.movie.data.network.MovieService
import com.sample.android.movie.data.response.asMovieDomainModel
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.domain.model.SortType
import com.sample.android.movie.data.paging.BasePageKeyedDataSource
import io.reactivex.Observable
import java.util.concurrent.Executor

class MoviePageKeyedDataSource(
    private val api: MovieService,
    private val sortType: SortType,
    retryExecutor: Executor,
    context: Context
) : BasePageKeyedDataSource<Movie>(retryExecutor, context) {

    override fun fetchItems(page: Int): Observable<List<Movie>> = when (sortType) {
        SortType.MOST_POPULAR -> api.popularMovies(page).map { it.items.asMovieDomainModel() }
        SortType.TRENDING -> api.trendingMovies(page).map { it.items.asMovieDomainModel() }
        SortType.DISCOVER -> api.discoverMovies(page).map { it.items.asMovieDomainModel() }
    }
}