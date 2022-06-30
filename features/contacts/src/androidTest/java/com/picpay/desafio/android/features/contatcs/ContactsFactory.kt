package com.picpay.desafio.android.features.contatcs

import com.picpay.desafio.android.core.commons.exception.UnknownException
import com.picpay.desafio.android.features.contatcs.data.model.ContactBinding
import com.picpay.desafio.android.features.contatcs.ui.contactslist.ContactsListViewState

object ContactsFactory {
    val CONTACT_IMAGE = android.R.drawable.bottom_bar
    val CONTACT_BINDING_1 = ContactBinding(
        id = 1,
        name = "Jonh Doe",
        username = "JDoe",
        img = CONTACT_IMAGE
    )

    val CONTACT_BINDING_2 = ContactBinding(
        id = 2,
        name = "Jonh Does",
        username = "JDoes",
        img = ""
    )

    val CONTACTS_BINDING = listOf(CONTACT_BINDING_1, CONTACT_BINDING_2)

    val VIEW_STATE_LIST = ContactsListViewState(
        contactList = CONTACTS_BINDING,
        isLoading = false,
        unexpectedError = null
    )

    val VIEW_STATE_ERROR = ContactsListViewState(
        contactList = listOf(),
        isLoading = false,
        unexpectedError = UnknownException()
    )

    val VIEW_STATE_LOADING = ContactsListViewState(
        contactList = listOf(),
        isLoading = true,
        unexpectedError = null
    )
}
