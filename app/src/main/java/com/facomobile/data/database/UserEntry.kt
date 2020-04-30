package com.facomobile.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntry(@PrimaryKey val id: String = "", var fullName: String,
                     var phoneNumber: String)