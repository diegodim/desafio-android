package com.picpay.desafio.android.features.contatcs.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ContactBinding(
    val img: @RawValue Any,
    val name: String,
    val id: Int,
    val username: String
) : Parcelable
