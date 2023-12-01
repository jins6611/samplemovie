package com.sample.android.movie.di.movie

import com.sample.android.movie.ui.paging.main.movie.PopularMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PopularMoviesModule {

    @ContributesAndroidInjector
    internal abstract fun popularMoviesFragment(): PopularMoviesFragment
}