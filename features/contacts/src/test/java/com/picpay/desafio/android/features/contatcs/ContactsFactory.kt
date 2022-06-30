package com.picpay.desafio.android.features.contatcs

import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel
import com.picpay.desafio.android.features.contatcs.data.model.ContactBinding

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

    val CONTACT_BINDING_1 = ContactBinding(
        id = 1,
        name = "Jonh Doe",
        username = "JDoe",
        img = ""
    )

    val CONTACT_BINDING_2 = ContactBinding(
        id = 2,
        name = "Jonh Does",
        username = "JDoes",
        img = ""
    )

    val CONTACTS_BINDING = listOf(CONTACT_BINDING_1, CONTACT_BINDING_2)
}
