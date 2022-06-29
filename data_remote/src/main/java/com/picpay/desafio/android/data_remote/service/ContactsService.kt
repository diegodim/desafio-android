package com.picpay.desafio.android.data_remote.service

import com.picpay.desafio.android.data_remote.model.contacts.ContactResponse
import retrofit2.Response
import retrofit2.http.GET

interface ContactsService {

    @GET(USERS)
    suspend fun getContacts(): Response<List<ContactResponse>>

    companion object {
        const val USERS = "users"
    }
}