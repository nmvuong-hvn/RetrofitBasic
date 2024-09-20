package com.kama.auto.retofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kama.auto.retofit.repository.RadioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class  MainViewModel (
    private  val radioRepository: RadioRepository,
)  : ViewModel() , KoinComponent {


    fun  getData() {
        viewModelScope.launch {
            radioRepository.fetchData()
        }
    }

}
