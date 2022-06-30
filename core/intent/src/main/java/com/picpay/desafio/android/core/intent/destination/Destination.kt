package com.picpay.desafio.android.core.intent.destination

import androidx.navigation.NamedNavArgument

sealed class Destination(val route: String) {
    object Contacts : Destination(route = "contacts")
}

sealed class LeafDestination(
    val root: Destination,
    private val route: String,
) {
    open val arguments: List<NamedNavArgument> = emptyList()
    fun createRoute() = "${root.route}/$route"
}