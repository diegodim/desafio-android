package com.picpay.desafio.android.repository.repository

import com.picpay.desafio.android.core.commons.base.Result
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

    override suspend fun refreshContacts(): Flow<Result<Unit>> = flow {
        contactsRemoteDataSource.getContacts().let {
            when (it) {
                is Result.Success -> {
                    contactsLocalDataSource.insertContacts(it.data)
                    emit(Result.Success(Unit))
                }
                is Result.Failure -> emit(Result.Failure(it.exception))
            }
        }
    }
}
