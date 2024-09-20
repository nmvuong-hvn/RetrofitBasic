package com.kama.auto.retofit.api.service

import android.util.Log
import com.kama.auto.retofit.api.controllers.safeCallApiNetwork
import com.kama.auto.retofit.api.model.RadioData
import com.kama.auto.retofit.api.model.ResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiClient (private val apiService: ApiService) {
    suspend fun getRadioList(): ResponseModel<RadioData> {
        return safeCallApiNetwork {
            apiService.getRadio()
        }
    }
}