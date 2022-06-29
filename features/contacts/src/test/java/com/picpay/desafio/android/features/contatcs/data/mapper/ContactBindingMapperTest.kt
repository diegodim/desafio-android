package com.picpay.desafio.android.features.contatcs.data.mapper

import com.picpay.desafio.android.features.contatcs.ContactsFactory.CONTACTS_BINDING
import com.picpay.desafio.android.features.contatcs.ContactsFactory.CONTACTS_MODEL
import com.picpay.desafio.android.features.contatcs.ContactsFactory.CONTACT_BINDING_1
import com.picpay.desafio.android.features.contatcs.ContactsFactory.CONTACT_MODEL_1
import org.junit.Assert
import org.junit.Test

class ContactBindingMapperTest{

    @Test
    fun `Assert ContactBindingMapper is mapping`() {
        Assert.assertEquals(CONTACTS_MODEL.mapFromDomain(), CONTACTS_BINDING)
        Assert.assertEquals(CONTACT_MODEL_1.mapFromDomain(), CONTACT_BINDING_1)
    }
}