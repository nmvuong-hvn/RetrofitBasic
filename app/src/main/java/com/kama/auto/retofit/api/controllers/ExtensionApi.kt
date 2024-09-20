package com.kama.auto.retofit.api.controllers

import android.util.Log
import com.kama.auto.retofit.api.model.ResponseModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

private const val TAG = "ExtensionApi"
suspend fun <T : Any> safeCallApiNetwork(apiCall : suspend () -> T): ResponseModel<T> = withContext(Dispatchers.IO) {
    try {
        val data = apiCall.invoke()
        ResponseModel(data = data, error = null)
    }catch (e : Exception) {
        ResponseModel(error = e.message, data = null)
    }
}


suspend fun <T:Any> safeCallApiCancellableNetwork(apiCall: suspend () -> T) = suspendCancellableCoroutine { conti ->
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        conti.resumeWithException(throwable)
    }
    conti.invokeOnCancellation {
        Log.d(TAG, "cancel call api")
    }
    if (conti.isActive) {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            if (conti.isActive && isActive) {
                val data = apiCall.invoke()
                conti.resume(data)
            }
        }
    }
}
