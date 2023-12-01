package com.sample.android.movie.di

import com.sample.android.movie.ui.feed.movie.FeedMovieFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FeedModule {

    @ContributesAndroidInjector
    internal abstract fun feedMovieFragment(): FeedMovieFragment

}