package com.picpay.desafio.android.datalocal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.android.datalocal.model.contacts.ContactEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {

    @Query("select * from contacts")
    fun getContacts(): Flow<List<ContactEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(vararg contact: ContactEntity)
}
