package com.sample.android.movie.di

import com.sample.android.movie.BuildConfig
import com.sample.android.movie.data.network.MovieService
import com.sample.android.movie.data.network.OkHttpProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun retrofit(): Retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.TMDB_BASE_URL)
                    .client(OkHttpProvider.instance)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

    @Singleton
    @Provides
    fun movieApi(retrofit: Retrofit): MovieService = retrofit.create(MovieService::class.java)
}