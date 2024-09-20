package com.kama.auto.retofit.api.di

import com.kama.auto.retofit.api.controllers.ApiController
import com.kama.auto.retofit.api.service.ApiClient
import com.kama.auto.retofit.api.service.ApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    val base_url = "https://jsonplaceholder.typicode.com";

    single {

        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(ApiService::class.java) }

    single { ApiClient(get()) }
    single { ApiController(get()) }
}
