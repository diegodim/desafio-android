package com.picpay.desafio.android.core.uikit.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.picpay.desafio.android.core.uikit.theme.ColorAccent

@Composable
fun CustomScaffold(
    modifier: Modifier = Modifier,
    iconStatusBarDark: Boolean = false,
    backgroundColor: Color = Color.Transparent,
    isLoading: Boolean = false,
    content: (@Composable ColumnScope.() -> Unit)? = null,
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = backgroundColor, darkIcons = iconStatusBarDark)

    Box(
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxSize()
        ) {
            content?.invoke(this)
        }
        AnimatedVisibility(
            modifier = Modifier.align(Alignment.TopCenter),
            visible = isLoading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            CircularProgressIndicator(color = ColorAccent)
        }
    }
}
