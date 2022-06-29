package com.picpay.desafio.android.core.intent.di

import com.picpay.desafio.android.core.intent.core.NavigationManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val intentModule = module {
    single { NavigationManager(CoroutineScope(SupervisorJob() + Dispatchers.Main)) }
}
