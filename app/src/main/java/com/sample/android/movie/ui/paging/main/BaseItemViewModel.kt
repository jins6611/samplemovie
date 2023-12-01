package com.sample.android.movie.ui.paging.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.sample.android.movie.ui.paging.BasePagingViewModel
import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.data.paging.Listing
import com.sample.android.movie.data.paging.BasePageKeyRepository

abstract class BaseItemViewModel<T : TmdbItem>(app: Application) : BasePagingViewModel<T>(app) {

    protected abstract val mainRepoResult : BasePageKeyRepository<T>

    override val repoResult: LiveData<Listing<T>> = liveData {
        emit(mainRepoResult.getItems())
    }
}