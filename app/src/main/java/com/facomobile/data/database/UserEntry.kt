package com.facomobile.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntry(@PrimaryKey val uid: String = "", var firstName: String,
                     var lastName: String?, var otherName: String?, var email: String?,
                     var phoneNumber: String?)