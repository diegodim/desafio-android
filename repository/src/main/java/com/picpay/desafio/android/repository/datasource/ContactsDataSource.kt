package com.picpay.desafio.android.repository.datasource

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel

interface ContactsDataSource {
    suspend fun getContacts(): Result<List<ContactModel>>
}