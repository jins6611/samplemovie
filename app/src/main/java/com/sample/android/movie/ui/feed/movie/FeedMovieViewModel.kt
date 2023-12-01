package com.sample.android.movie.ui.feed.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.data.repository.MovieFeedRepository
import com.sample.android.movie.ui.feed.FeedViewModel
import javax.inject.Inject

class FeedMovieViewModel(repository: MovieFeedRepository) :
    FeedViewModel<Movie>(repository) {

    class Factory @Inject constructor(
        private val repository: MovieFeedRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FeedMovieViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return FeedMovieViewModel(repository) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

}