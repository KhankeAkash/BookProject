package com.example.bookproject.RoomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey val loginId: String,
    val userName: String?,
    val token: String?,
    val tenantId: Int?,
    val roleCode: String?,
    val userFName: String?,
    val userLName: String?,
    val userDisplayName: String?,
    val userBaseBranchCode: String?,
    val assignedBranch: String?,
    val authStatus: String?,
    val preferLang: String?
)
