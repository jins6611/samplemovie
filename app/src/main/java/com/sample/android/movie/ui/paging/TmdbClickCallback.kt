package com.sample.android.movie.ui.paging

import android.os.Parcelable

interface TmdbClickCallback<T : Parcelable> {
    fun onClick(t: T)
}