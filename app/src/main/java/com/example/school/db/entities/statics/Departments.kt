package com.example.school.db.entities.statics

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.school.utils.Constants.Departments.DEPARTMENT_ID
import com.example.school.utils.Constants.Departments.DEPARTMENT_NAME
import com.example.school.utils.Constants.Departments.DEPARTMENT_TABLE

@Entity(tableName = DEPARTMENT_TABLE)
data class Departments(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(DEPARTMENT_ID)
    val ID_Department: Int = 0,
    @ColumnInfo(DEPARTMENT_NAME)
    val Department_Name: String,
    )