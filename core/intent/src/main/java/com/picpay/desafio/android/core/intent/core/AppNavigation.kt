package com.picpay.desafio.android.core.intent.core

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.picpay.desafio.android.core.intent.destination.Destination
import com.picpay.desafio.android.core.intent.graph.addContactsNavGraph

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Destination.Contacts.route,
        modifier = modifier,
    ) {
        addContactsNavGraph()
    }
}
