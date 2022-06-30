package com.picpay.desafio.android.data_remote.mapper.contacts

import com.picpay.desafio.android.data_remote.model.contacts.ContactResponse
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel

fun ContactResponse.mapToDomain() = ContactModel(
    img = img ?: String(),
    name = name ?: String(),
    id = id ?: 0,
    username = username ?: String()
)

fun List<ContactResponse>.mapToDomain() = map { it.mapToDomain() }
