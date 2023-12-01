package com.sample.android.movie.ui.paging.main.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.data.network.MovieService
import com.sample.android.movie.ui.feed.NavType
import com.sample.android.movie.ui.paging.main.BaseItemFragment
import javax.inject.Inject

abstract class MovieFragment : BaseItemFragment<Movie>() {

    @Inject
    lateinit var api: MovieService

    override val viewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return MovieViewModel(api, sortType, requireNotNull(activity).application) as T
            }
        })[MovieViewModel::class.java]
    }

    override val navType: NavType
        get() = NavType.MOVIES
}