package com.sample.android.movie.di.movie

import com.sample.android.movie.ui.paging.main.movie.DiscoverMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DiscoverMoviesModule {

    @ContributesAndroidInjector
    internal abstract fun discoverMoviesFragment(): DiscoverMoviesFragment
}