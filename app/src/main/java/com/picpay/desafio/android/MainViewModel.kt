package com.picpay.desafio.android

import androidx.lifecycle.ViewModel
import com.picpay.desafio.android.core.intent.core.NavigationManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel : ViewModel(), KoinComponent {
    val navigationManager: NavigationManager by inject()
}