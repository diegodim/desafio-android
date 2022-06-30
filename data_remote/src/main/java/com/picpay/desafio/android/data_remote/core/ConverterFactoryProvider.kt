package com.picpay.desafio.android.data_remote.core

import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory

object ConverterFactoryProvider {

    operator fun invoke(): GsonConverterFactory {
        val builder = GsonBuilder()
        return GsonConverterFactory.create(builder.create())
    }
}
