package com.picpay.desafio.android.domain.contactsusecase.usecase

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.core.commons.base.UseCase
import com.picpay.desafio.android.domain.contactsusecase.repository.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class RefreshContactsUseCase(
    scope: CoroutineScope,
    private val repository: ContactsRepository
) : UseCase<Unit, Unit>(scope) {
    override suspend fun run(params: Unit?): Flow<Result<Unit>> = repository.refreshContacts()
}
