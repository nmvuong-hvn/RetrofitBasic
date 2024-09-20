package com.kama.auto.retofit.repository

import com.kama.auto.retofit.api.controllers.ApiController
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RadioRepositoryImpl() : RadioRepository , KoinComponent {
    private val apiController: ApiController by inject()
    override suspend fun fetchData() {
        apiController.requestRadioList {  }
    }


}