package com.picpay.desafio.android.datalocal.datasource

import com.picpay.desafio.android.core.commons.base.Result
import com.picpay.desafio.android.datalocal.ContactsFactory.CONTACTS_ENTITY
import com.picpay.desafio.android.datalocal.ContactsFactory.CONTACTS_MODEL
import com.picpay.desafio.android.datalocal.dao.ContactsDao
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ContactsLocalDataSourceImplTest {

    private lateinit var dataSource: ContactsLocalDataSourceImpl

    private val contactsDao: ContactsDao = mockk()

    @Before
    fun setup() {
        MockKAnnotations.init()
        dataSource = ContactsLocalDataSourceImpl(contactsDao)
    }

    @Test
    fun `WHEN getContacts HAS success MUST return a result data mapped`() = runBlocking {
        every { contactsDao.getContacts() } returns flowOf(CONTACTS_ENTITY)

        val result = dataSource.getContacts()

        Assert.assertEquals(result.first(), Result.Success(CONTACTS_MODEL))
    }

    @Test(expected = RuntimeException::class)
    fun `WHEN getContacts HAS failure MUST throw a exception`() {
        coEvery { contactsDao.getContacts() } throws RuntimeException()

        dataSource.getContacts()
    }
}
