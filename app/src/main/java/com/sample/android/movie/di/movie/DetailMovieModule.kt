package com.sample.android.movie.di.movie

import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.ui.detail.movie.DetailMovieActivity
import com.sample.android.movie.ui.detail.movie.DetailMovieFragment
import com.sample.android.movie.util.Constants.EXTRA_TMDB_ITEM
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailMovieModule {

    @ContributesAndroidInjector
    internal abstract fun detailMovieFragment(): DetailMovieFragment

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun provideTmdbItem(activity: DetailMovieActivity): TmdbItem =
            activity.intent.extras?.getParcelable(EXTRA_TMDB_ITEM)!!
    }
}
