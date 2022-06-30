package com.picpay.desafio.android.datalocal

import com.picpay.desafio.android.datalocal.model.contacts.ContactEntity
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel

object ContactsFactory {

    val CONTACT_MODEL_1 = ContactModel(
        id = 1,
        name = "Jonh Doe",
        username = "JDoe",
        img = ""
    )

    val CONTACT_MODEL_2 = ContactModel(
        id = 2,
        name = "Jonh Does",
        username = "JDoes",
        img = ""
    )

    val CONTACTS_MODEL = listOf(CONTACT_MODEL_1, CONTACT_MODEL_2)

    val CONTACT_ENTITY_1 = ContactEntity(
        id = 1,
        name = "Jonh Doe",
        username = "JDoe",
        img = ""
    )

    val CONTACT_ENTITY_2 = ContactEntity(
        id = 2,
        name = "Jonh Does",
        username = "JDoes",
        img = ""
    )

    val CONTACTS_ENTITY = listOf(CONTACT_ENTITY_1, CONTACT_ENTITY_2)
}
