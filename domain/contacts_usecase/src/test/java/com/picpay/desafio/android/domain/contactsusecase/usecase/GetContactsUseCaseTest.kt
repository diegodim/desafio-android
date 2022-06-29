package com.picpay.desafio.android.domain.contactsusecase.usecase

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.core.commons.exception.UnknownException
import com.picpay.desafio.android.domain.contactsusecase.ContactsUseCaseFactory.CONTACTS
import com.picpay.desafio.android.domain.contactsusecase.repository.ContactsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetContactsUseCaseTest {
    private lateinit var useCase: GetContactsUseCase
    private val authRepository: ContactsRepository = mockk()

    @Before
    fun setup() {
        MockKAnnotations.init()
        useCase = GetContactsUseCase(
            CoroutineScope(Dispatchers.Unconfined),
            authRepository
        )
    }

    @Test
    fun `WHEN getContacts HAS success MUST call repository once and return a flow with success data`(): Unit =
        runBlocking {
            coEvery { authRepository.getContacts() } returns flowOf(Result.Success(CONTACTS))

            val result = useCase.run(Unit)

            coVerify(exactly = 1) { authRepository.getContacts() }
            Assert.assertEquals(result.first(), Result.Success(CONTACTS))

        }

    @Test
    fun `WHEN getContacts HAS failure MUST call repository once and return a flow with failure exception`(): Unit =
        runBlocking {
            val error = RuntimeException()
            coEvery { authRepository.getContacts() } returns flowOf(Result.Failure(error))

            val result = useCase.run(Unit)

            coVerify(exactly = 1) { authRepository.getContacts() }
            Assert.assertEquals(result.first(), Result.Failure(error))
        }
}