package com.example.bookproject.RoomDB.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bookproject.RoomDB.UserEntity
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user : UserEntity)

    @Query ("SELECT * FROM user_table LIMIT 1")
            suspend fun getUser(): UserEntity?

    @Query("DELETE FROM user_table")
    suspend fun clearUser()
}