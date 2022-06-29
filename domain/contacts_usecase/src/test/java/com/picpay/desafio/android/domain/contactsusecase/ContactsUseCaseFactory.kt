package com.picpay.desafio.android.domain.contactsusecase

import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel

object ContactsUseCaseFactory {
    val CONTACT_1 = ContactModel(
        id = 1,
        name = "Jonh Doe",
        username = "JDoe",
        img = ""
    )

    val CONTACT_2 = ContactModel(
        id = 2,
        name = "Jonh Does",
        username = "JDoes",
        img = ""
    )

    val CONTACTS = listOf(CONTACT_1, CONTACT_2)
}