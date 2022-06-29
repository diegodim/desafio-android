package com.picpay.desafio.android.features.contatcs.ui.contactslist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.picpay.desafio.android.core.delegate.useCase
import com.picpay.desafio.android.domain.contactsusecase.usecase.GetContactsUseCase
import com.picpay.desafio.android.features.contatcs.data.mapper.mapFromDomain
import com.picpay.desafio.android.features.contatcs.ui.contactslist.ContactsListViewAction.*
import org.koin.core.component.KoinComponent

class ContactsListViewModel : ViewModel(), KoinComponent {
    var viewState by mutableStateOf(ContactsListViewState())
        private set

    val getContactsUseCase: GetContactsUseCase by useCase()

    fun dispatchViewAction(viewAction: ContactsListViewAction) {
        when (viewAction) {
            is Get.ContactList -> getContactList()
            is Navigate.Contact -> Unit
            is Clear.UnexpectedError -> viewState = viewState.copy(unexpectedError = null)
        }
    }

    private fun getContactList() {
        viewState = viewState.copy(isLoading = true, unexpectedError = null)
        getContactsUseCase(
            onSuccess = { contactList ->
                viewState = viewState.copy(contactList = contactList.mapFromDomain(), isLoading = false)
            },
            onFailure = {throwable ->
                viewState = viewState.copy(unexpectedError = throwable, isLoading = false)
            }
        )
    }
}