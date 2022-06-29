package com.picpay.desafio.android.domain.contactsusecase.usecase

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.core.commons.base.UseCase
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel
import com.picpay.desafio.android.domain.contactsusecase.repository.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetContactsUseCase(
    scope: CoroutineScope,
    private val repository: ContactsRepository
) : UseCase<Unit, List<ContactModel>>(scope) {
    override suspend fun run(params: Unit?): Flow<Result<List<ContactModel>>> =
        repository.getContacts()
}