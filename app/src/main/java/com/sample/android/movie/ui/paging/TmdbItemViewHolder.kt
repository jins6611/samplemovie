package com.sample.android.movie.ui.paging

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.android.movie.databinding.TmdbItemBinding
import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.util.layoutInflater

class TmdbItemViewHolder(val binding: TmdbItemBinding)
    : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun <T : TmdbItem> create(parent: ViewGroup, tmdbClickCallback: TmdbClickCallback<T>): TmdbItemViewHolder {
            val binding: TmdbItemBinding = TmdbItemBinding.inflate(parent.context.layoutInflater,
                    parent, false)
            binding.callback = tmdbClickCallback
            return TmdbItemViewHolder(binding)
        }
    }
}