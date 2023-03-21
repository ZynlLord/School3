package com.example.school.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.example.school.db.entities.statics.Departments
import com.example.school.utils.Constants

@Entity(
    tableName = "employee",
    foreignKeys = [
        ForeignKey(
            entity = Departments::class,
            parentColumns = ["id_department"],
            childColumns = ["department_id"],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["id_user"],
            childColumns = ["user_id"],
            onDelete = CASCADE
        ),

    ]
)
data class Employee(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_employee")
    val ID_Employee: Int,
    @ColumnInfo("department_id")
    val Department_ID: Int,
    @ColumnInfo("user_id")
    val User_ID: Int,
)
