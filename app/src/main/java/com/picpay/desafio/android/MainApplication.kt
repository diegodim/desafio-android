package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.core.intent.di.intentModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("unused")
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                intentModule
            ).androidContext(applicationContext).androidLogger()
        }
    }
}