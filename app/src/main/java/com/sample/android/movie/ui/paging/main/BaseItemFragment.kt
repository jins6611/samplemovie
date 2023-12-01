package com.sample.android.movie.ui.paging.main

import com.sample.android.movie.domain.model.SortType
import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.ui.paging.BaseFragment

abstract class BaseItemFragment<T : TmdbItem> : BaseFragment<T>() {

    protected abstract val sortType: SortType
}