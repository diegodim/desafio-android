package com.picpay.desafio.android.features.contatcs.ui.contactslist

import com.picpay.desafio.android.features.contatcs.data.model.ContactBinding

sealed class ContactsListViewAction {
    object Get {
        object ContactList : ContactsListViewAction()
    }

    object Navigate {
        data class Contact(val contact: ContactBinding) : ContactsListViewAction()
    }

    object Clear {
        object UnexpectedError : ContactsListViewAction()
    }
}
