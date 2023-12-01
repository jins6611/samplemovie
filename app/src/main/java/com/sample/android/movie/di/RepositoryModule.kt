package com.sample.android.movie.di

import com.sample.android.movie.data.repository.MovieDetailRepositoryImpl
import com.sample.android.movie.data.repository.MovieFeedRepository
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.domain.repository.BaseFeedRepository
import com.sample.android.movie.domain.repository.MovieDetailRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    internal abstract fun bindMovieFeedRepository(movieFeedRepository: MovieFeedRepository): BaseFeedRepository<Movie>

    @Singleton
    @Binds
    internal abstract fun bindMovieDetailRepository(movieDetailRepository: MovieDetailRepositoryImpl): MovieDetailRepository
}