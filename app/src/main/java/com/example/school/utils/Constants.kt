package com.example.school.utils

import com.example.school.db.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY: DatabaseRepository

object Constants {
    object Keys {
        const val DATABASE_NAME = "school_database"
        const val USERS_TABLE = "users"
        const val USER_LOGIN = "user_login"
        const val USER_PASSWORD = "user_password"
        const val USER_NAME = "user_name"
        const val USER_SURNAME = "user_surname"
        const val USER_LASTNAME = "user_lastname"
        const val USER_PHONE = "user_phone"
        const val ID = "Id"
        const val NONE = "none"
    }

    object Screens {

    }
}