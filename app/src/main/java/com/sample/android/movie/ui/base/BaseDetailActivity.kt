package com.sample.android.movie.ui.base

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.sample.android.movie.R
import com.sample.android.movie.databinding.ActivityDetailBinding
import com.sample.android.movie.util.addFragmentToActivity
import dagger.android.support.DaggerFragment

abstract class BaseDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityDetailBinding

    override val networkStatusLayout: View by lazy { binding.itemContainer.networkStatusLayout }

    override val textViewNetworkStatus: TextView by lazy { binding.itemContainer.textViewNetworkStatus }

    protected abstract val fragment: DaggerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            addFragmentToActivity(fragment, R.id.fragment_container)
        }
    }
}