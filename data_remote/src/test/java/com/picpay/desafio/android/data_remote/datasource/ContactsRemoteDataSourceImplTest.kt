package com.picpay.desafio.android.data_remote.datasource

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.core.commons.exception.UnknownException
import com.picpay.desafio.android.data_remote.ContactsFactory.CONTACTS_MODEL
import com.picpay.desafio.android.data_remote.ContactsFactory.CONTACTS_RESPONSE
import com.picpay.desafio.android.data_remote.core.NetworkWrapper
import com.picpay.desafio.android.data_remote.model.contacts.ContactResponse
import com.picpay.desafio.android.data_remote.service.ContactsService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

class ContactsRemoteDataSourceImplTest {

    private lateinit var dataSource: ContactsRemoteDataSourceImpl

    private val contactsService: ContactsService = mockk()
    private val networkWrapper: NetworkWrapper = mockk()

    private val testModule = module {
        single { networkWrapper }
    }

    @Before
    fun setup() {
        GlobalContext.startKoin { modules(testModule) }
        MockKAnnotations.init()
        dataSource = ContactsRemoteDataSourceImpl(contactsService)
    }

    @After
    fun reset() {
        GlobalContext.stopKoin()
    }

    @Test
    fun `WHEN getContacts HAS success MUST return a result data mapped`(): Unit =
        runBlocking {
            coEvery { networkWrapper<List<ContactResponse>>(any()) } returns CONTACTS_RESPONSE

            val result = dataSource.getContacts()

            Assert.assertEquals(result, Result.Success(CONTACTS_MODEL))
        }

    @Test
    fun `WHEN getContacts HAS failure MUST throw a exception`(): Unit =
        runBlocking {
            val error = UnknownException()
            coEvery { networkWrapper<List<ContactResponse>>(any()) } throws error

            val result = dataSource.getContacts()

            Assert.assertEquals(result, Result.Failure(error))
        }
}