package com.picpay.desafio.android.features.contatcs.data.mapper

import com.picpay.desafio.android.domain.contactsusecase.model.ContactModel
import com.picpay.desafio.android.features.contatcs.data.model.ContactBinding

fun ContactModel.mapFromDomain() = ContactBinding(
    img = img,
    name = name,
    id = id,
    username = username
)

fun List<ContactModel>.mapFromDomain() = map { it.mapFromDomain() }
