package com.picpay.desafio.android.features.contatcs.ui.contactslist


import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.picpay.desafio.android.core.uikit.R.string
import com.picpay.desafio.android.core.uikit.component.CustomScaffold
import com.picpay.desafio.android.core.uikit.extension.getString
import com.picpay.desafio.android.core.uikit.theme.Spacing
import com.picpay.desafio.android.core.uikit.theme.Typography
import com.picpay.desafio.android.features.contatcs.data.model.ContactBinding
import com.picpay.desafio.android.features.contatcs.ui.component.ContactListItem
import com.picpay.desafio.android.features.contatcs.ui.contactslist.ContactsListViewAction.*

@Composable
fun ContactsListScreen(viewModel: ContactsListViewModel) {
    val viewState = viewModel.viewState
    val action: (ContactsListViewAction) -> Unit = { viewModel.dispatchViewAction(it) }
    Content(viewState = viewState, action = action)
}

@Composable
fun Content(viewState: ContactsListViewState, action: (ContactsListViewAction) -> Unit) {
    LaunchedEffect(Unit) {
        action(Get.ContactList)
    }
    val context = LocalContext.current
    val errorMessage = string.error_contacts_unexpected.getString()

    CustomScaffold(
        iconStatusBarDark = false,
        backgroundColor = MaterialTheme.colors.primary,
        isLoading = viewState.isLoading
    ) {
        List(contactList = viewState.contactList, onClick = { Navigate.Contact(it) })
    }
    LaunchedEffect(viewState.unexpectedError) {
        if (viewState.unexpectedError != null) {
            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
            action(Clear.UnexpectedError)
        }
    }
}

@Composable
private fun List(contactList: List<ContactBinding>, onClick: (ContactBinding) -> Unit) {
    LazyColumn(modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()) {
        item {
            Text(
                modifier = Modifier.padding(start = Spacing.Large, top = Spacing.Huge),
                text = string.content_contacts_title.getString(),
                style = Typography.h1
            )
        }
        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Spacing.Large)
            )
        }
        items(items = contactList, key = { it.id }) { contact ->
            ContactListItem(contact = contact, onClick = onClick)
        }
    }
}
