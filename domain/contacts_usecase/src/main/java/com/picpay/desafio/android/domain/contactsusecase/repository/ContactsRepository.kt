package com.picpay.desafio.android.domain.contactsusecase.repository

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel
import kotlinx.coroutines.flow.Flow

interface ContactsRepository {
    suspend fun getContacts(): Flow<Result<List<ContactModel>>>
}