package com.picpay.desafio.android.core.commons.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

abstract class UseCase<in Params, out T>(private val scope: CoroutineScope) {

    abstract suspend fun run(params: Params?): Result<T>

    operator fun invoke(
        params: Params? = null,
        onFailure: ((Throwable) -> Unit) = {},
        onSuccess: (T) -> Unit = {}
    ) {
        scope.launch(handleError(onFailure)) {
            run(params).fold(
                onSuccess = {
                    onSuccess(it)
                },
                onFailure = {
                    onFailure(it)
                }
            )
        }
    }

    private fun handleError(onError: (Throwable) -> Unit): CoroutineContext {
        return CoroutineExceptionHandler { _, throwable -> onError(throwable) }
    }

    fun cancel() = scope.coroutineContext.cancelChildren()
}
