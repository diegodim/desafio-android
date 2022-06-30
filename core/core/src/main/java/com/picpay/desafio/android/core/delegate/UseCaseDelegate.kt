package com.picpay.desafio.android.core.delegate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.core.commons.base.UseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

inline fun <V, reified U> V.useCase() where U : UseCase<*, *>, V : ViewModel, V : KoinComponent =
    inject<U> {
        parametersOf(viewModelScope)
    }
