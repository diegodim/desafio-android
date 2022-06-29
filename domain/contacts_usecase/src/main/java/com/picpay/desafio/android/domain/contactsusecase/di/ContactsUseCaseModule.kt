package com.picpay.desafio.android.domain.contactsusecase.di

import com.picpay.desafio.android.domain.contactsusecase.usecase.GetContactsUseCase
import com.picpay.desafio.android.domain.contactsusecase.usecase.RefreshContactsUseCase
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val contactsUseCaseModule = module {
    factory { (scope: CoroutineScope) ->
        GetContactsUseCase(scope, get())
    }

    factory { (scope: CoroutineScope) ->
        RefreshContactsUseCase(scope, get())
    }
}