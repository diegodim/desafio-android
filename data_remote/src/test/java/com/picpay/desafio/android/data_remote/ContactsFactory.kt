package com.picpay.desafio.android.data_remote

import com.picpay.desafio.android.data_remote.model.contacts.ContactResponse
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

    val CONTACT_RESPONSE_1 = ContactResponse(
        id = 1,
        name = "Jonh Doe",
        username = "JDoe",
        img = ""
    )

    val CONTACT_RESPONSE_2 = ContactResponse(
        id = 2,
        name = "Jonh Does",
        username = "JDoes",
        img = null
    )

    val CONTACTS_RESPONSE = listOf(CONTACT_RESPONSE_1, CONTACT_RESPONSE_2)
}
