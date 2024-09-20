package com.kama.auto.retofit

import android.app.Application
import com.kama.auto.retofit.api.di.apiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules( appModule , apiModule )
        }
    }
}