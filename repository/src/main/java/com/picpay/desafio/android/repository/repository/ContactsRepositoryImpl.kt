package com.picpay.desafio.android.repository.repository

import com.picpay.desafio.android.domain.contactsusecase.repository.ContactsRepository
import com.picpay.desafio.android.repository.datasource.ContactsDataSource
import kotlinx.coroutines.flow.flow


class ContactsRepositoryImpl(
    private val contactsDataSource: ContactsDataSource
) : ContactsRepository {

    override suspend fun getContacts() = flow{
        emit(contactsDataSource.getContacts())
    }
}