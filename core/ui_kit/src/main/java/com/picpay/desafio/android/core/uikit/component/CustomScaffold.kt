package com.picpay.desafio.android.core.uikit.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.picpay.desafio.android.core.uikit.theme.ColorAccent

const val TAG_SCAFFOLD_PROGRESS_INDICATOR = "ScaffoldProgressIndicator"

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

    Column(
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        content?.invoke(this)
        AnimatedVisibility(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            visible = isLoading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            CircularProgressIndicator(
                modifier = Modifier.testTag(TAG_SCAFFOLD_PROGRESS_INDICATOR),
                color = ColorAccent
            )
        }
    }
}
