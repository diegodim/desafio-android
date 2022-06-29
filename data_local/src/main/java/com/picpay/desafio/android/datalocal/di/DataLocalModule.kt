package com.picpay.desafio.android.datalocal.di

import com.picpay.desafio.android.datalocal.core.AppDatabase
import com.picpay.desafio.android.datalocal.datasource.ContactsLocalDataSourceImpl
import com.picpay.desafio.android.repository.datasource.local.ContactsLocalDataSource
import org.koin.dsl.module

val dataLocalModule = module {
    single { AppDatabase.provideDatabase(get()) }

    single { get<AppDatabase>().contactsDao() }

    single<ContactsLocalDataSource> {
        ContactsLocalDataSourceImpl(get())
    }
}
