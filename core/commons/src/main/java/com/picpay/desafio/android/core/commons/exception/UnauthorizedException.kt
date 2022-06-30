package com.picpay.desafio.android.core.commons.exception

class UnauthorizedException(message: String? = null, title: String? = null) :
    RuntimeException(message, Throwable(title))
