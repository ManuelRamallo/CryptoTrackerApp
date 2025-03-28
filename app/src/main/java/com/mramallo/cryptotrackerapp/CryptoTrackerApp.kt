package com.mramallo.cryptotrackerapp

import android.app.Application
import android.content.Context
import com.mramallo.cryptotrackerapp.core.domain.util.KeystoreHelper
import com.mramallo.cryptotrackerapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CryptoTrackerApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KeystoreHelper.generateKey()
        startKoin {
            instance = this@CryptoTrackerApp
            androidContext(this@CryptoTrackerApp)
            androidLogger()

            modules(appModule)
        }
    }

    companion object {
        private lateinit var instance: CryptoTrackerApp
        fun getContext(): Context = instance.applicationContext
    }

}