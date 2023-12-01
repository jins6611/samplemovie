package com.sample.android.movie.domain.repository

import com.sample.android.movie.domain.model.CreditWrapper
import com.sample.android.movie.domain.model.Video
import io.reactivex.Single

interface MovieDetailRepository {

    fun getMovieTrailers(movieId: Int): Single<List<Video>>

    fun getMovieCredit(movieId: Int): CreditWrapper
}