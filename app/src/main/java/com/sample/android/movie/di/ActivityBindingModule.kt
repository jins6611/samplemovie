package com.sample.android.movie.di

import com.sample.android.movie.di.movie.*
import com.sample.android.movie.ui.detail.movie.DetailMovieActivity
import com.sample.android.movie.ui.feed.FeedActivity
import com.sample.android.movie.ui.paging.main.movie.*
import com.sample.android.movie.ui.paging.search.movie.SearchMovieActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [FeedModule::class])
    internal abstract fun feedActivity(): FeedActivity

    @ContributesAndroidInjector(modules = [TrendingMoviesModule::class])
    internal abstract fun trendingMoviesActivity(): TrendingMoviesActivity


    @ContributesAndroidInjector(modules = [PopularMoviesModule::class])
    internal abstract fun popularMoviesActivity(): PopularMoviesActivity


    @ContributesAndroidInjector(modules = [DiscoverMoviesModule::class])
    internal abstract fun discoverMoviesActivity(): DiscoverMoviesActivity

    @ContributesAndroidInjector(modules = [SearchMovieModule::class])
    internal abstract fun searchMovieActivity(): SearchMovieActivity


    @ContributesAndroidInjector(modules = [DetailMovieModule::class])
    internal abstract fun detailMovieActivity(): DetailMovieActivity


}