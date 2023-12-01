package com.sample.android.movie.domain.repository

import android.content.Context
import com.sample.android.movie.R
import com.sample.android.movie.domain.model.FeedWrapper
import com.sample.android.movie.domain.model.SortType
import com.sample.android.movie.domain.model.TmdbItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

abstract class BaseFeedRepository<T : TmdbItem>(
    context: Context,
    ioDispatcher: CoroutineDispatcher
) : BaseRepository<List<FeedWrapper<T>>>(context, ioDispatcher) {

    protected abstract suspend fun popularItems(): List<T>



    protected abstract suspend fun trendingItems(): List<T>

    protected abstract suspend fun discoverItems(): List<T>

    protected abstract fun getLatestResId(): Int

    override suspend fun getSuccessResult(): List<FeedWrapper<T>> {
        val trendingDeferred: Deferred<List<T>>
        val popularDeferred: Deferred<List<T>>
        val discoverDeferred: Deferred<List<T>>
        coroutineScope {
            trendingDeferred = async { trendingItems() }
            popularDeferred = async { popularItems() }
            discoverDeferred = async { discoverItems() }
        }
        return listOf(
            FeedWrapper(
                trendingDeferred.await(),
                R.string.text_trending,
                SortType.TRENDING
            ),
            FeedWrapper(
                popularDeferred.await(),
                R.string.text_popular,
                SortType.MOST_POPULAR
            ),
            FeedWrapper(
                discoverDeferred.await(),
                R.string.text_discover,
                SortType.DISCOVER
            )
        )
    }
}