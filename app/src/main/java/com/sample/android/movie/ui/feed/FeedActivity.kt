package com.sample.android.movie.ui.feed

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.sample.android.movie.R
import com.sample.android.movie.databinding.ActivityFeedBinding
import com.sample.android.movie.ui.base.BaseNavTypeActivity
import com.sample.android.movie.ui.feed.movie.FeedMovieFragment
import com.sample.android.movie.util.addFragmentToActivity
import javax.inject.Inject

class FeedActivity : BaseNavTypeActivity() {

    @Inject
    lateinit var feedMovieFragment: FeedMovieFragment

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityFeedBinding

    override val navType: NavType
        get() = viewModel.currentType.value ?: NavType.MOVIES

    override val toolbar: Toolbar
        get() = binding.toolbar

    override val networkStatusLayout: View by lazy { binding.itemContainer.networkStatusLayout }

    override val textViewNetworkStatus: TextView by lazy { binding.itemContainer.textViewNetworkStatus }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        viewModel.headline.observe(this) {
            title = getString(it)
        }
        if (savedInstanceState == null) {
            addFragmentToActivity(feedMovieFragment, R.id.fragment_container)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


}