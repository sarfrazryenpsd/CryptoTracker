package com.ryen.cryptotracker

import android.app.Application
import com.ryen.cryptotracker.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CryptoTrackerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CryptoTrackerApp)
            modules(appModule)
        }
    }
}