package com.sample.android.movie.domain.repository

import com.sample.android.movie.domain.model.Person
import io.reactivex.Single

interface PersonRepository {

    fun getPerson(personId: Any): Single<Person>
}