package com.kama.auto.retofit.api.controllers

import android.content.Context
import android.util.Log
import com.kama.auto.retofit.api.service.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ApiController(private val context: Context) : KoinComponent {
    private val apiClient: ApiClient by inject()

    suspend fun requestRadioList(onComplete: suspend () -> Unit): Unit = withContext(Dispatchers.IO) {
        apiClient.getRadioList().let { result ->
            Log.d("DATA", "DATA AA ${result.data} - ${result.error}")
            onComplete.invoke()
        }
    }
}