package com.sample.android.movie.data.response

import com.google.gson.annotations.SerializedName
import com.sample.android.movie.domain.model.Video
import com.sample.android.movie.util.Constants.ID
import com.sample.android.movie.util.Constants.NAME

class VideoResponse(
    @SerializedName(ID)
    val id: String,
    @SerializedName(NAME)
    val name: String,
    @SerializedName("site")
    val site: String,
    @SerializedName("key")
    val videoId: String,
    @SerializedName("type")
    val type: String
)

fun List<VideoResponse>.asDomainModel(): List<Video> =
    map { Video(it.id, it.name, it.site, it.videoId, it.type) }