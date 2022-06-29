package com.picpay.desafio.android.data_remote.datasource

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.core.commons.base.runCatchingResult
import com.picpay.desafio.android.data_remote.core.NetworkWrapper
import com.picpay.desafio.android.data_remote.mapper.contacts.mapToDomain
import com.picpay.desafio.android.data_remote.service.ContactsService
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel
import com.picpay.desafio.android.repository.datasource.ContactsDataSource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ContactsDataSourceImpl(
    private val contactsService: ContactsService
) : ContactsDataSource, KoinComponent {
    private val networkWrapper: NetworkWrapper by inject()

    override suspend fun getContacts(): Result<List<ContactModel>> = runCatchingResult {
        networkWrapper {
            contactsService.getContacts()
        }.mapToDomain()
    }
}
