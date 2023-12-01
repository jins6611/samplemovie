package com.sample.android.movie.data.paging

import com.sample.android.movie.domain.model.TmdbItem

interface PageKeyRepository<T : TmdbItem> {
    fun getItems(): Listing<T>
}