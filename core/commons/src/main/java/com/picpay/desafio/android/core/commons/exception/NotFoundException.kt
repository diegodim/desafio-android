package com.picpay.desafio.android.core.commons.exception

class NotFoundException(message: String? = null, title: String? = null) :
    RuntimeException(message, Throwable(title))
