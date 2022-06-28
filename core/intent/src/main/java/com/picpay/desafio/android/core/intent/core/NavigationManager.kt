package com.picpay.desafio.android.core.intent.core

import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@Suppress("unused")
class NavigationManager(private val applicationScope: CoroutineScope) {

    private val _commands: Channel<NavigationCommand> = Channel(Channel.BUFFERED)
    val commands = _commands.receiveAsFlow()

    /**
     * Navigate to a route in the current NavGraph. If an invalid route is given, an
     * [IllegalArgumentException] will be thrown.
     *
     * @param route route for the destination
     */
    private fun navigate(route: String, navOptions: NavOptions? = null) {
        applicationScope.launch {
            _commands.send(
                NavigationCommand.Navigate(
                    destination = route,
                    type = NavigationType.NavigateTo,
                    navOptions = navOptions
                )
            )
        }
    }

    fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit) {
        navigate(route, navOptions(builder))
    }

    fun navigateUp() {
        applicationScope.launch {
            _commands.send(NavigationCommand.NavigateUp)
        }
    }

    /**
     * Attempts to pop the controller's back stack back to a specific destination.
     *
     * @param route The topmost destination to retain
     * @param inclusive Whether the given destination should also be popped.
     */
    fun popStackTo(route: String, inclusive: Boolean) {
        applicationScope.launch {
            _commands.send(
                NavigationCommand.Navigate(
                    destination = route,
                    type = NavigationType.PopUpTo(inclusive)
                )
            )
        }
    }

    fun popStackBack() {
        applicationScope.launch {
            _commands.send(NavigationCommand.PopStackBack)
        }
    }
}

sealed class NavigationType {

    object NavigateTo : NavigationType()

    class PopUpTo(val inclusive: Boolean) : NavigationType()
}

sealed class NavigationCommand {

    data class Navigate(
        val destination: String,
        val navOptions: NavOptions? = null,
        val type: NavigationType,
    ) : NavigationCommand()

    object NavigateUp : NavigationCommand()

    object PopStackBack : NavigationCommand()
}
