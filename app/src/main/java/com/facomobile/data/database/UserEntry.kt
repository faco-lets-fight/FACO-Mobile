package com.facomobile.data.database

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntry(@PrimaryKey val id: String = "", var firstName: String,
                         var lastName: String, var token: String) {
    @Ignore
    val fullName = "$firstName $lastName"
}