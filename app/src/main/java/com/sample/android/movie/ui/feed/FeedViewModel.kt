package com.sample.android.movie.ui.feed

import com.sample.android.movie.domain.model.FeedWrapper
import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.domain.repository.BaseFeedRepository
import com.sample.android.movie.ui.base.BaseViewModel

open class FeedViewModel<T : TmdbItem>(
    repository: BaseFeedRepository<T>,
) : BaseViewModel<List<FeedWrapper<T>>>(repository)