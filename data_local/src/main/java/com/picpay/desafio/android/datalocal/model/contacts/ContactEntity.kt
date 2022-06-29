package com.picpay.desafio.android.datalocal.model.contacts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class ContactEntity(
    @PrimaryKey
    val id: Int,
    val img: String?,
    val name: String?,
    val username: String?
)
