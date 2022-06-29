package com.picpay.desafio.android.core.commons.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Failure -> "Error[exception=$exception]"
        }
    }
}

suspend fun <T> Flow<Result<T>>.collectResult(onSuccess: (T) -> Unit, onFailure: (Exception) -> Unit) {
    this.collect { result ->
        when(result){
            is Result.Success -> {
                onSuccess(result.data)
            }
            is Result.Failure -> {
                onFailure(result.exception)
            }
        }
    }
}
inline fun <R> runCatchingResult(block: () -> R): Result<R> {
    return try {
        Result.Success(block())
    } catch (e: Exception) {
        Result.Failure(e)
    }
}
