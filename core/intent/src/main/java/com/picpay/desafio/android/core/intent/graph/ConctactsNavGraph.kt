package com.picpay.desafio.android.core.intent.graph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.google.accompanist.navigation.animation.composable
import com.picpay.desafio.android.core.intent.destination.ContactsDestination
import com.picpay.desafio.android.core.intent.destination.Destination
import com.picpay.desafio.android.features.contatcs.ui.contactslist.ContactsListScreen
import org.koin.androidx.compose.getViewModel

@ExperimentalAnimationApi
fun NavGraphBuilder.addContactsNavGraph() {
    navigation(
        route = Destination.Contacts.route,
        startDestination = ContactsDestination.List.createRoute()
    ) {
        addContactList()
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addContactList() {
    composable(
        route = ContactsDestination.List.createRoute()
    ) {
        ContactsListScreen(getViewModel())
    }
}
