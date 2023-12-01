package com.sample.android.movie.ui.detail

import com.sample.android.movie.domain.model.Cast
import com.sample.android.movie.domain.model.CreditWrapper
import com.sample.android.movie.domain.model.Crew
import com.sample.android.movie.domain.model.Video
import com.sample.android.movie.ui.base.BaseDetailViewModel
import com.sample.android.movie.ui.detail.DetailViewModel.DetailWrapper
import io.reactivex.Single

open class DetailViewModel(
    trailers: Single<List<Video>>,
    credits: CreditWrapper
) : BaseDetailViewModel<DetailWrapper>(
    Single.zip(trailers, credits.cast, credits.crew) { videos, cast, crew ->
        DetailWrapper(videos, cast, crew)
    }
) {
    class DetailWrapper(
        val videos: List<Video>,
        val cast: List<Cast>,
        val crew: List<Crew>
    )
}