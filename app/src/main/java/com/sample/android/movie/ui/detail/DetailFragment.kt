package com.sample.android.movie.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.sample.android.movie.R
import com.sample.android.movie.databinding.FragmentDetailBinding
import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.ui.base.BaseDetailFragment
import com.sample.android.movie.util.setupActionBar
import com.sample.android.movie.util.toVisibility
import javax.inject.Inject

abstract class DetailFragment : BaseDetailFragment<DetailViewModel, FragmentDetailBinding>
    (R.layout.fragment_detail) {

    @Inject
    lateinit var tmdbItem: TmdbItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        with(binding) {
            tmdbItem = this@DetailFragment.tmdbItem

            with(activity as AppCompatActivity) {
                setupActionBar(detailsToolbar) {
                    setDisplayShowTitleEnabled(false)
                    setDisplayHomeAsUpEnabled(true)
                    setDisplayShowHomeEnabled(true)
                }
            }


            this@DetailFragment.tmdbItem.overview.trim().isNotEmpty().also {
                summaryLabel.toVisibility(it)
                summary.toVisibility(it)
            }

            summary.setOnClickListener {
                val maxLine = resources.getInteger(R.integer.max_lines)
                summary.maxLines = if (summary.maxLines > maxLine) maxLine else Int.MAX_VALUE
            }
        }
        return binding.root
    }



}