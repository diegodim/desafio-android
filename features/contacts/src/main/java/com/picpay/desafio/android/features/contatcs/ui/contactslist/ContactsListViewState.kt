package com.picpay.desafio.android.features.contatcs.ui.contactslist

import com.picpay.desafio.android.features.contatcs.data.model.ContactBinding

data class ContactsListViewState(
    val contactList: List<ContactBinding> = listOf(),
    val isLoading: Boolean = false,
    val unexpectedError: Throwable? = null
)
