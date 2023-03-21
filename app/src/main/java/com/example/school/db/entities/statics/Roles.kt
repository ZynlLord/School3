package com.example.school.db.entities.statics

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.school.utils.Constants.Roles.ROLES_TABLE
import com.example.school.utils.Constants.Roles.ROLE_ID
import com.example.school.utils.Constants.Roles.ROLE_NAME


@Entity(tableName = ROLES_TABLE)
data class Roles(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(ROLE_ID)
    val ID_Roles: Int = 0,
    @ColumnInfo(ROLE_NAME)
    val Role_Name: String =""
)