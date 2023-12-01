package com.sample.android.movie.data.repository

import com.sample.android.movie.data.network.MovieService
import com.sample.android.movie.data.response.asCreditWrapper
import com.sample.android.movie.data.response.asDomainModel
import com.sample.android.movie.domain.repository.MovieDetailRepository
import com.sample.android.movie.domain.model.CreditWrapper
import com.sample.android.movie.domain.model.Video
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailRepositoryImpl @Inject constructor(
    private val movieApi: MovieService
) : MovieDetailRepository {

    override fun getMovieTrailers(movieId: Int): Single<List<Video>> =
        movieApi.movieTrailers(movieId).map { it.videos.asDomainModel() }

    override fun getMovieCredit(movieId: Int): CreditWrapper =
         movieApi.movieCredit(movieId).asCreditWrapper()
}