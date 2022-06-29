package com.picpay.desafio.android.data_remote.mapper.contacts

import com.picpay.desafio.android.data_remote.ContactsFactory.CONTACTS_MODEL
import com.picpay.desafio.android.data_remote.ContactsFactory.CONTACTS_RESPONSE
import com.picpay.desafio.android.data_remote.ContactsFactory.CONTACT_MODEL_1
import com.picpay.desafio.android.data_remote.ContactsFactory.CONTACT_RESPONSE_1
import org.junit.Assert
import org.junit.Test

class ContactResponseMapperTest{

        @Test
        fun `Assert ContactResponseMapper is working`() {
            Assert.assertEquals(CONTACTS_RESPONSE.mapToDomain(), CONTACTS_MODEL)
            Assert.assertEquals(CONTACT_RESPONSE_1.mapToDomain(), CONTACT_MODEL_1)
        }
}