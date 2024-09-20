package com.kama.auto.retofit.api.controllers

import com.kama.auto.retofit.api.model.ResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


suspend fun <T : Any> safeCallApiNetwork(apiCall : suspend () -> T): ResponseModel<T> = withContext(Dispatchers.IO) {
    try {
        val data = apiCall.invoke()
        ResponseModel(data = data, error = null)
    }catch (e : Exception) {
        ResponseModel(error = e.message, data = null)
    }
}