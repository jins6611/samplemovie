package com.sample.android.movie.di.movie

import com.sample.android.movie.ui.paging.search.movie.SearchMovieFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchMovieModule {

    @ContributesAndroidInjector
    internal abstract fun searchMovieFragment(): SearchMovieFragment
}