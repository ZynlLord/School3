package com.example.school.utils

import com.example.school.db.repository.DatabaseRepository

const val TYPE_ROOM = "type_room"
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
        const val USER_PHOTO = "user_photo"
        const val ID = "Id"
        const val LOGIN = "Login"
        const val NONE = "none"
    }

    object Roles {
        const val ROLES_TABLE = "roles_table"
        const val ROLE_ID = "id_role"
        const val ROLE_NAME = "role_name"
    }

    object Departments {
        const val DEPARTMENT_TABLE = "departments_table"
        const val DEPARTMENT_ID = "id_department"
        const val DEPARTMENT_NAME = "department_name"
    }

    object Addresses {
        const val ADDRESSES_TABLE = "adresses_table"
        const val ADDRESSES_ID = "id_adresses"
        const val ADDRESSES_NAME = "addresses_name"
    }

    object Statuses {
        const val STATUSES_TABLE = "statuses_table"
        const val STATUS_ID = "id_statuses"
        const val STATUS_NAME = "status_name"
    }

    object Post {
        const val POST_TABLE = "posts_table"
        const val POST_ID = "id_user"
        const val POST_NAME = "id_department"
    }


    object Words {
        const val NAME = "Имя"
        const val SURNAME = "Фамилия"
        const val LASTNAME = "Отчество"
        const val EMAIL = "Почта"
        const val PHONE_RU = "Телефон"
        const val SIGNUP_RU = "Зарегистрироваться"
    }
}