package com.sample.android.movie.domain.model

class Person(
    val birthDay: String?,
    val deathDay: String?,
    val id: Int,
    val alsoKnowAs: Array<String>,
    val biography: String,
    val placeOfBirth: String?
)