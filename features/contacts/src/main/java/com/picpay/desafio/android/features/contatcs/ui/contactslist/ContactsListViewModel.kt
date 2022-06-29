package com.picpay.desafio.android.features.contatcs.ui.contactslist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.picpay.desafio.android.core.delegate.useCase
import com.picpay.desafio.android.domain.contactsusecase.usecase.GetContactsUseCase
import com.picpay.desafio.android.domain.contactsusecase.usecase.RefreshContactsUseCase
import com.picpay.desafio.android.features.contatcs.data.mapper.mapFromDomain
import com.picpay.desafio.android.features.contatcs.ui.contactslist.ContactsListViewAction.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ContactsListViewModel : ViewModel(), KoinComponent {
    var viewState by mutableStateOf(ContactsListViewState())
        private set

    private val navigation: ContactsListNavigation by inject()
    private val getContactsUseCase: GetContactsUseCase by useCase()
    private val refreshContactsUseCase: RefreshContactsUseCase by useCase()

    fun dispatchViewAction(viewAction: ContactsListViewAction) {
        when (viewAction) {
            is Get.ContactList -> getContactList()
            is Navigate.Contact -> navigation.navigateToContactDetails(viewAction.contact)
            is Clear.UnexpectedError -> clearUnexpectedError()
        }
    }

    private fun getContactList() {
        viewState = viewState.copy(isLoading = true, unexpectedError = null)
        refreshContacts()
        getContactsUseCase(
            onSuccess = { contactList ->
                viewState =
                    viewState.copy(contactList = contactList.mapFromDomain(), isLoading = contactList.isEmpty())
            },
            onFailure = { throwable ->
                viewState = viewState.copy(unexpectedError = throwable, isLoading = false)
            }
        )
    }
    private fun refreshContacts(){
        refreshContactsUseCase(
            onSuccess = {
                viewState = viewState.copy( isLoading = false)
            }
        )
    }

    private fun clearUnexpectedError() {
        viewState = viewState.copy(unexpectedError = null)
    }
}