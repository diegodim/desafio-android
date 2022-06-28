package com.picpay.desafio.android.core.uikit.extension

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun Int.getString(): String = stringResource(this)

