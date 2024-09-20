package com.kama.auto.retofit.api.service

import com.kama.auto.retofit.api.model.RadioData
import com.kama.auto.retofit.api.model.ResponseModel
import retrofit2.http.GET

interface ApiService {

    @GET("/posts/1")
    suspend fun getRadio(): RadioData

}