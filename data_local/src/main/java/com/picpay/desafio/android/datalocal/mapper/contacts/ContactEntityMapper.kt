package com.picpay.desafio.android.datalocal.mapper.contacts

import com.picpay.desafio.android.datalocal.model.contacts.ContactEntity
import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel

fun ContactEntity.mapToDomain() = ContactModel(
    img = img ?: String(),
    name = name ?: String(),
    id = id,
    username = username ?: String()
)

fun List<ContactEntity>.mapToDomain() = map { it.mapToDomain() }

fun ContactModel.mapFromDomain() = ContactEntity(
    img = img,
    name = name,
    id = id,
    username = username
)

fun List<ContactModel>.mapFromDomain() = map { it.mapFromDomain() }
