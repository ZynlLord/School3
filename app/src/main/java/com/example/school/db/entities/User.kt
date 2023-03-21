package com.example.school.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.school.utils.Constants.Keys.USERS_TABLE
import com.example.school.utils.Constants.Keys.USER_LASTNAME
import com.example.school.utils.Constants.Keys.USER_LOGIN
import com.example.school.utils.Constants.Keys.USER_NAME
import com.example.school.utils.Constants.Keys.USER_PASSWORD
import com.example.school.utils.Constants.Keys.USER_PHONE
import com.example.school.utils.Constants.Keys.USER_PHOTO
import com.example.school.utils.Constants.Keys.USER_SURNAME

@Entity(tableName = USERS_TABLE)
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_user")
    val ID_User: Int = 0,
    @ColumnInfo(name = USER_LOGIN)
    val User_Login: String,
    @ColumnInfo(name = USER_PASSWORD)
    val User_Password: String,
    @ColumnInfo(name = USER_NAME)
    val User_Name: String,
    @ColumnInfo(name = USER_SURNAME)
    val User_Surname: String,
    @ColumnInfo(name = USER_LASTNAME)
    val User_LastName: String,
    @ColumnInfo(name = USER_PHONE)
    val User_Phone: String,
    @ColumnInfo(name = USER_PHOTO)
    val User_Photo: String
)
