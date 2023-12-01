package com.sample.android.movie.ui.detail

import android.view.MenuItem
import com.sample.android.movie.ui.base.BaseDetailActivity

abstract class DetailActivity : BaseDetailActivity() {

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