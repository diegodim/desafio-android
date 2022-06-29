package com.picpay.desafio.android.features.contatcs.di

import com.picpay.desafio.android.domain.contactsusecase.di.contactsUseCaseModule
import com.picpay.desafio.android.features.contatcs.ui.contactslist.ContactsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val contactsModule = module {
    viewModel { ContactsListViewModel() }

    loadKoinModules(contactsUseCaseModule)
}