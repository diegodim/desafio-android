package com.picpay.desafio.android.repository.repository

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.core.commons.base.onSuccess
import com.picpay.desafio.android.core.commons.base.runCatchingResult
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel
import com.picpay.desafio.android.domain.contactsusecase.repository.ContactsRepository
import com.picpay.desafio.android.repository.datasource.local.ContactsLocalDataSource
import com.picpay.desafio.android.repository.datasource.remote.ContactsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ContactsRepositoryImpl(
    private val contactsRemoteDataSource: ContactsRemoteDataSource,
    private val contactsLocalDataSource: ContactsLocalDataSource
) : ContactsRepository {

    override suspend fun getContacts(): Flow<Result<List<ContactModel>>> =
        contactsLocalDataSource.getContacts()

    override suspend fun refreshContacts() = flow {
        emit(
            runCatchingResult {
                contactsRemoteDataSource.getContacts().onSuccess {
                    contactsLocalDataSource.insertContacts(it)
                }
            }
        )
    }
}
