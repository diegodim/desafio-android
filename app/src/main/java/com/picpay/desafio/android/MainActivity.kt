package com.picpay.desafio.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.picpay.desafio.android.core.intent.core.NavigationCommand
import com.picpay.desafio.android.core.intent.core.NavigationType
import com.picpay.desafio.android.core.intent.core.AppNavigation
import com.picpay.desafio.android.core.uikit.theme.DesafioandroidTheme
import kotlinx.coroutines.flow.collect

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberAnimatedNavController()
            DesafioandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ObserveAndNavigate(viewModel, navController)
                    AppNavigation(modifier = Modifier.fillMaxSize(), navController = navController)
                }
            }
        }
    }
}

@Composable
fun ObserveAndNavigate(viewModel: MainViewModel, navController: NavHostController) {
    LaunchedEffect(Unit) {
        viewModel.navigationManager.commands.collect { command ->
            when (command) {
                is NavigationCommand.Navigate -> {
                    when (val type = command.type) {
                        NavigationType.NavigateTo -> {
                            navController.navigate(
                                route = command.destination,
                                navOptions = command.navOptions
                            )
                        }
                        is NavigationType.PopUpTo -> {
                            navController.popBackStack(
                                route = command.destination,
                                inclusive = type.inclusive
                            )
                        }
                    }
                }
                is NavigationCommand.NavigateUp ->
                    navController.navigateUp()
                is NavigationCommand.PopStackBack ->
                    navController.popBackStack()
            }
        }
    }
}
