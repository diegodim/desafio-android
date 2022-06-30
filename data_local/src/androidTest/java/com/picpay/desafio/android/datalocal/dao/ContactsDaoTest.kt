package com.picpay.desafio.android.datalocal.dao

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.picpay.desafio.android.datalocal.ContactsFactory.CONTACT_ENTITY
import com.picpay.desafio.android.datalocal.core.AppDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
internal class ContactsDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var contactsDao: ContactsDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).allowMainThreadQueries()
            .build()
        contactsDao = database.contactsDao()
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testInsertContactAndGetAllContacts() = runBlocking {
        contactsDao.insertContact(CONTACT_ENTITY)
        val actual = contactsDao.getContacts()

        Assert.assertTrue(actual.first().contains(CONTACT_ENTITY))
    }
}
