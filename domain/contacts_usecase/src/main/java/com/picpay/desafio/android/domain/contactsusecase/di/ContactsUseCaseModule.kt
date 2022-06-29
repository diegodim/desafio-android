package com.picpay.desafio.android.domain.contactsusecase.di

import com.picpay.desafio.android.domain.contactsusecase.usecase.GetContactsUseCase
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val contactsUseCaseModule = module {
    factory { (scope: CoroutineScope) ->
        GetContactsUseCase(scope, get())
    }
}