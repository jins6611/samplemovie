package com.sample.android.movie.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class SortType : Parcelable {
    TRENDING,
    MOST_POPULAR,
    DISCOVER
}