package com.picpay.desafio.android.datalocal

import com.picpay.desafio.android.datalocal.model.contacts.ContactEntity
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel

object ContactsFactory {
    val CONTACT_ENTITY = ContactEntity(
        id = 1,
        name = "Jonh Doe",
        username = "JDoe",
        img = ""
    )
}