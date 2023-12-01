package com.sample.android.movie.data.response

import com.google.gson.annotations.SerializedName
import com.sample.android.movie.domain.model.Cast
import com.sample.android.movie.domain.model.Crew
import com.sample.android.movie.util.Constants.BASE_WIDTH_342_PATH
import com.sample.android.movie.util.Constants.ID
import com.sample.android.movie.util.Constants.NAME

class NetworkCast(
    @SerializedName("character")
    val role: String,
    @SerializedName(NAME)
    val name: String,
    @SerializedName(PROFILE_PATH)
    val profilePath: String?,
    @SerializedName(ID)
    val id: Int
)

class NetworkCrew(
    @SerializedName("job")
    val role: String,
    @SerializedName(NAME)
    val name: String,
    @SerializedName(PROFILE_PATH)
    val profilePath: String?,
    @SerializedName(ID)
    val id: String
)

fun List<NetworkCast>.asCastDomainModel(): List<Cast> = map {
    Cast(it.role, it.name, it.profilePath?.let { profilePath ->
        String.format(
            BASE_WIDTH_342_PATH,
            profilePath
        )
    }, it.id)
}

fun List<NetworkCrew>.asCrewDomainModel(): List<Crew> = map {
    Crew(it.role, it.name, it.profilePath?.let { profilePath ->
        String.format(
            BASE_WIDTH_342_PATH,
            profilePath
        )
    }, it.id)
}

private const val PROFILE_PATH = "profile_path"