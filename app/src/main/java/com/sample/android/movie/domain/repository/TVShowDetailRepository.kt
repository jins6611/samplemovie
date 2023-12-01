package com.sample.android.movie.domain.repository

import com.sample.android.movie.domain.model.CreditWrapper
import com.sample.android.movie.domain.model.Video
import io.reactivex.Single

interface TVShowDetailRepository {

    fun getTVShowTrailers(tvId: Int): Single<List<Video>>

    fun getTVShowCredit(tvId: Int): CreditWrapper
}