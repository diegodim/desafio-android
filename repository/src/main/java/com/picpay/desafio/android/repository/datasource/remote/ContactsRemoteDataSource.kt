package com.picpay.desafio.android.repository.datasource.remote

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel

interface ContactsRemoteDataSource {
    suspend fun getContacts(): Result<List<ContactModel>>
}
