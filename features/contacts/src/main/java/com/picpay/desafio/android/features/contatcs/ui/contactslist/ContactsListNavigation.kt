package com.picpay.desafio.android.features.contatcs.ui.contactslist

import com.picpay.desafio.android.features.contatcs.data.model.ContactBinding

interface ContactsListNavigation {
    fun navigateToContactDetails(contactBinding: ContactBinding)
}
