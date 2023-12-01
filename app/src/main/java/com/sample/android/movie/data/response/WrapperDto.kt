package com.sample.android.movie.data.response

import com.google.gson.annotations.SerializedName
import com.sample.android.movie.domain.model.CreditWrapper
import com.sample.android.movie.data.response.NetworkCast
import com.sample.android.movie.data.response.NetworkCrew
import com.sample.android.movie.data.response.asCastDomainModel
import com.sample.android.movie.data.response.asCrewDomainModel
import io.reactivex.Single

class TMDbWrapper<T : NetworkTmdbItem>(
    @SerializedName("results")
    val items: List<T>
)

class VideoWrapper(
    @SerializedName("results")
    val videos: List<VideoResponse>
)

class NetworkCreditWrapper(
    @SerializedName("cast")
    val cast: List<NetworkCast>,
    @SerializedName("crew")
    val crew: List<NetworkCrew>
)

fun Single<NetworkCreditWrapper>.asCreditWrapper(): CreditWrapper {
    val cast = map { it.cast.asCastDomainModel() }
    val crew = map { it.crew.asCrewDomainModel() }
    return CreditWrapper(cast, crew)
}