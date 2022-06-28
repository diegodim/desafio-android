package com.picpay.desafio.android.features.contatcs.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContactBinding(
    val img: String,
    val name: String,
    val id: Int,
    val username: String
):Parcelable
