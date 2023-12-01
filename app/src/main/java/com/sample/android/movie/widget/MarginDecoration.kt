package com.sample.android.movie.widget

import android.content.Context
import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.sample.android.movie.R

class MarginDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val margin: Int = context.resources.getDimensionPixelSize(R.dimen.padding_small)

    override fun getItemOffsets(
            outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.set(margin, margin, margin, margin)
    }
}