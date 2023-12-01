package com.sample.android.movie.data.repository

import android.content.Context
import com.sample.android.movie.R
import com.sample.android.movie.data.response.asMovieDomainModel
import com.sample.android.movie.di.IoDispatcher
import com.sample.android.movie.domain.repository.BaseFeedRepository
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.data.network.MovieService
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieFeedRepository @Inject constructor(
    context: Context,
    @IoDispatcher ioDispatcher: CoroutineDispatcher,
    private val movieApi: MovieService,
): BaseFeedRepository<Movie>(context, ioDispatcher) {

    override suspend fun popularItems(): List<Movie> = movieApi.popularMovies().items.asMovieDomainModel()

    override suspend fun trendingItems(): List<Movie> = movieApi.trendingMovies().items.asMovieDomainModel()


    override suspend fun discoverItems(): List<Movie> = movieApi.discoverMovies().items.asMovieDomainModel()


    override fun getLatestResId(): Int = R.string.text_upcoming
}