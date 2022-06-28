package com.picpay.desafio.android.features.contatcs.ui.contacts_list


import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.picpay.desafio.android.core.uikit.R.string
import com.picpay.desafio.android.core.uikit.component.CustomScaffold
import com.picpay.desafio.android.core.uikit.extension.getString
import com.picpay.desafio.android.core.uikit.theme.ColorPrimary
import com.picpay.desafio.android.core.uikit.theme.Spacing
import com.picpay.desafio.android.core.uikit.theme.Typography

@Composable
fun ContactsListScreen() {
    val context = LocalContext.current
    var errorMessage by remember { mutableStateOf(String()) }

    CustomScaffold(
        iconStatusBarDark = false,
        backgroundColor = ColorPrimary
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Text(
                    modifier = Modifier.padding(start = Spacing.Large, top = Spacing.Huge),
                    text = string.content_contacts_title.getString(),
                    style = Typography.h1
                )
            }
        }
    }
    LaunchedEffect(errorMessage) {
        if (errorMessage != String()) {
            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
        }
    }
}

