package com.kama.auto.retofit

import com.kama.auto.retofit.repository.RadioRepository
import com.kama.auto.retofit.repository.RadioRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<RadioRepository> { RadioRepositoryImpl() }
    viewModel { MainViewModel(get(),) }
}