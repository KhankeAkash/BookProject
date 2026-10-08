package com.example.bookproject.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookproject.RoomDB.Dao.UserDao

@Database(entities = [UserEntity::class], version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                    .build().also { INSTANCE = it }
            }
    }
}