package com.picpay.desafio.android.core.intent.destination

object ContactsDestination {
    object List : LeafDestination(
        root = Destination.Contacts,
        route = "list"
    )
}