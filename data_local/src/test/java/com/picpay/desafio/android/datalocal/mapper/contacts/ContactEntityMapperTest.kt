package com.picpay.desafio.android.datalocal.mapper.contacts

import com.picpay.desafio.android.datalocal.ContactsFactory.CONTACTS_ENTITY
import com.picpay.desafio.android.datalocal.ContactsFactory.CONTACTS_MODEL
import com.picpay.desafio.android.datalocal.ContactsFactory.CONTACT_ENTITY_1
import com.picpay.desafio.android.datalocal.ContactsFactory.CONTACT_MODEL_1
import org.junit.Assert
import org.junit.Test

class ContactEntityMapperTest {
    @Test
    fun `Assert ContactEntityMapper is mapping`() {
        Assert.assertEquals(CONTACTS_ENTITY.mapToDomain(), CONTACTS_MODEL)
        Assert.assertEquals(CONTACT_ENTITY_1.mapToDomain(), CONTACT_MODEL_1)
        Assert.assertEquals(CONTACTS_MODEL.mapFromDomain(), CONTACTS_ENTITY)
        Assert.assertEquals(CONTACT_MODEL_1.mapFromDomain(), CONTACT_ENTITY_1)
    }
}
