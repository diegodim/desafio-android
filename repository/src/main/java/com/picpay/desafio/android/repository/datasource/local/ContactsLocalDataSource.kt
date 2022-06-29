package com.picpay.desafio.android.repository.datasource.local

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel
import kotlinx.coroutines.flow.Flow

interface ContactsLocalDataSource {
    fun getContacts(): Flow<Result<List<ContactModel>>>
    suspend fun insertContacts(contacts: List<ContactModel>): Result<Unit>
}