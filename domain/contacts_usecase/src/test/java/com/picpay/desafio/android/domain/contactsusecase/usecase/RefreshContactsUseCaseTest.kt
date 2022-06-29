package com.picpay.desafio.android.domain.contactsusecase.usecase

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.core.commons.exception.UnknownException
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

class RefreshContactsUseCaseTest {
    private lateinit var useCase: RefreshContactsUseCase
    private val authRepository: ContactsRepository = mockk()

    @Before
    fun setup() {
        MockKAnnotations.init()
        useCase = RefreshContactsUseCase(
            CoroutineScope(Dispatchers.Unconfined),
            authRepository
        )
    }

    @Test
    fun `WHEN refreshContacts HAS success MUST call repository once and return a flow with success unit`(): Unit =
        runBlocking {
            coEvery { authRepository.refreshContacts() } returns flowOf(
                Result.Success(
                    Unit
                )
            )

            val result = useCase.run(Unit)

            coVerify(exactly = 1) { authRepository.refreshContacts() }
            Assert.assertEquals(result.first(), Result.Success(Unit))
        }

    @Test
    fun `WHEN refreshContacts HAS failure MUST call repository once and return a flow with failure exception`(): Unit =
        runBlocking {
            val error = UnknownException()
            coEvery { authRepository.refreshContacts() } returns flowOf(Result.Failure(error))

            val result = useCase.run(Unit)

            coVerify(exactly = 1) { authRepository.refreshContacts() }
            Assert.assertEquals(result.first(), Result.Failure(error))
        }
}
