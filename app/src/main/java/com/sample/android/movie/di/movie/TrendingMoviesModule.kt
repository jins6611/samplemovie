package com.sample.android.movie.di.movie

import com.sample.android.movie.ui.paging.main.movie.TrendingMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TrendingMoviesModule {

    @ContributesAndroidInjector
    internal abstract fun trendingMoviesFragment(): TrendingMoviesFragment
}