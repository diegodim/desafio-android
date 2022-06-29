package com.picpay.desafio.android.datalocal.datasource

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.core.commons.base.runCatchingResult
import com.picpay.desafio.android.datalocal.dao.ContactsDao
import com.picpay.desafio.android.datalocal.mapper.contacts.mapFromDomain
import com.picpay.desafio.android.datalocal.mapper.contacts.mapToDomain
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel
import com.picpay.desafio.android.repository.datasource.local.ContactsLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ContactsLocalDataSourceImpl(private val contactsDao: ContactsDao) : ContactsLocalDataSource {

    override fun getContacts(): Flow<Result<List<ContactModel>>> =
        contactsDao.getContacts().map { contacts ->
            runCatchingResult { contacts.mapToDomain() }
        }

    override suspend fun insertContacts(contacts: List<ContactModel>):Result<Unit> = runCatchingResult {
        contacts.mapFromDomain().forEach {
            contactsDao.insertContact(it)
        }
    }
}
