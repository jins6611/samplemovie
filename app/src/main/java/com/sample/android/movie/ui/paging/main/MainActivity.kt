package com.sample.android.movie.ui.paging.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.sample.android.movie.R
import com.sample.android.movie.databinding.ActivityMainBinding
import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.ui.base.BaseNavTypeActivity
import com.sample.android.movie.util.addFragmentToActivity
import com.sample.android.movie.util.setupActionBar

abstract class MainActivity<T : TmdbItem> : BaseNavTypeActivity() {

    private lateinit var binding: ActivityMainBinding

    protected abstract val fragment: BaseItemFragment<T>

    protected abstract val screenTitle: String

    override val toolbar: Toolbar
        get() = binding.toolbar

    override val networkStatusLayout: View by lazy { binding.itemContainer.networkStatusLayout }

    override val textViewNetworkStatus: TextView by lazy { binding.itemContainer.textViewNetworkStatus }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActionBar(binding.toolbar) {
            setDisplayHomeAsUpEnabled(true)
        }
        title = screenTitle
        if (savedInstanceState == null) {
            addFragmentToActivity(fragment, R.id.fragment_container)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}