package com.sample.android.movie.ui.base

import android.app.ActivityOptions
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.sample.android.movie.R
import com.sample.android.movie.ui.feed.NavType
import com.sample.android.movie.ui.paging.search.movie.SearchMovieActivity


abstract class BaseNavTypeActivity : BaseActivity() {

    protected abstract val toolbar: Toolbar

    protected abstract val navType: NavType

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        if (navType == NavType.SETTING) {
            menu.getItem(0).isVisible = false
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> {
                val searchMenuView: View = toolbar.findViewById(R.id.action_search)
                val options = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    searchMenuView, getString(R.string.transition_search_back)
                )

                val activityClass = when (navType) {
                    NavType.MOVIES -> SearchMovieActivity::class.java
                    else -> throw RuntimeException("Unknown search navigation type")
                }
                val intent = Intent(this, activityClass)
                startActivity(intent, options.toBundle())
            }
        }
        return super.onOptionsItemSelected(item)
    }
}