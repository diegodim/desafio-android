package com.picpay.desafio.android.core.commons.exception

class UnknownException(message: String? = null, title: String? = null) :
    RuntimeException(message, Throwable(title))
