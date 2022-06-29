package com.picpay.desafio.android.datalocal.core

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.picpay.desafio.android.datalocal.dao.ContactsDao
import com.picpay.desafio.android.datalocal.model.contacts.ContactEntity

@Database(
    entities = [
        ContactEntity::class
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao

    companion object {
        fun provideDatabase(application: Application) =
            Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                "AppDatabase.db"
            ).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }
}
