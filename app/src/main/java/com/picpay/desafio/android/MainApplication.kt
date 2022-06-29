package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.core.intent.di.intentModule
import com.picpay.desafio.android.data_remote.di.dataRemoteModule
import com.picpay.desafio.android.datalocal.di.dataLocalModule
import com.picpay.desafio.android.features.contatcs.di.contactsModule
import com.picpay.desafio.android.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("unused")
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                intentModule,
                contactsModule,
                dataLocalModule,
                dataRemoteModule,
                repositoryModule
            ).androidContext(applicationContext).androidLogger()
        }
    }
}