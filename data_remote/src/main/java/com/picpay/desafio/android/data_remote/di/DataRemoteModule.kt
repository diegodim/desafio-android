package com.picpay.desafio.android.data_remote.di

import com.picpay.desafio.android.data_remote.core.ConverterFactoryProvider
import com.picpay.desafio.android.data_remote.core.NetworkConnection
import com.picpay.desafio.android.data_remote.core.NetworkWrapper
import com.picpay.desafio.android.data_remote.core.Retrofit
import com.picpay.desafio.android.data_remote.datasource.ContactsDataSourceImpl
import com.picpay.desafio.android.data_remote.service.ContactsService
import com.picpay.desafio.android.repository.datasource.ContactsDataSource
import org.koin.dsl.module
import retrofit2.Converter

val dataRemoteModule = module {
    single<Converter.Factory> { ConverterFactoryProvider() }

    single { NetworkWrapper() }

    single<ContactsService> {
        Retrofit(
            converterFactory = get(),
            baseUrl = NetworkConnection.CONTACTS_URL,
        )
    }

    single<ContactsDataSource> { ContactsDataSourceImpl(get()) }
}
