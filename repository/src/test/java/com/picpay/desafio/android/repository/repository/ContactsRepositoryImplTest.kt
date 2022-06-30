package com.picpay.desafio.android.repository.repository

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.core.commons.exception.UnknownException
import com.picpay.desafio.android.repository.ContactsRepositoryFactory.CONTACTS
import com.picpay.desafio.android.repository.datasource.local.ContactsLocalDataSource
import com.picpay.desafio.android.repository.datasource.remote.ContactsRemoteDataSource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ContactsRepositoryImplTest {
    private lateinit var repository: ContactsRepositoryImpl
    private val contactsLocalDataSource: ContactsLocalDataSource = mockk()
    private val contactsRemoteDataSource: ContactsRemoteDataSource = mockk()

    @Before
    fun setup() {
        MockKAnnotations.init()
        repository = ContactsRepositoryImpl(
            contactsRemoteDataSource,
            contactsLocalDataSource
        )
    }

    @Test
    fun `WHEN getContacts HAS success MUST be call localDataSource once and return a flow with result data`(): Unit =
        runBlocking {
            coEvery { contactsLocalDataSource.getContacts() } returns flowOf(Result.Success(CONTACTS))

            val result = repository.getContacts()

            coVerify(exactly = 1) { contactsLocalDataSource.getContacts() }
            Assert.assertEquals(result.first(), Result.Success(CONTACTS))
        }

    @Test
    fun `WHEN getContacts HAS failure MUST call localDataSource once and return a flow with failure exception`(): Unit =
        runBlocking {
            val error = RuntimeException()
            coEvery { contactsLocalDataSource.getContacts() } returns flowOf(Result.Failure(error))

            val result = repository.getContacts()

            coVerify(exactly = 1) { contactsLocalDataSource.getContacts() }
            Assert.assertEquals(result.first(), Result.Failure(error))
        }

    @Test
    fun `WHEN refreshContacts HAS success MUST be call remoteDataSource and insert on localDataSource`(): Unit =
        runBlocking {
            coEvery { contactsRemoteDataSource.getContacts() } returns Result.Success(CONTACTS)
            coEvery { contactsLocalDataSource.insertContacts(any()) } returns Result.Success(Unit)

            val result = repository.refreshContacts()

            Assert.assertTrue(result.first() is Result.Success)
            coVerify(exactly = 1) { contactsRemoteDataSource.getContacts() }
            coVerify(exactly = 1) { contactsLocalDataSource.insertContacts(any()) }
        }

    @Test
    fun `WHEN refreshContacts HAS failure MUST return a flow with failure exception`(): Unit =
        runBlocking {
            val error = UnknownException()
            coEvery { contactsRemoteDataSource.getContacts() } returns Result.Failure(error)

            val result = repository.refreshContacts()

            Assert.assertEquals(result.first(), Result.Failure(error))
        }
}
