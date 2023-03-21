package com.example.school.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.example.school.db.entities.statics.Addresses
import com.example.school.db.entities.statics.Departments

@Entity(tableName = "application_table",
foreignKeys = [ForeignKey(
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
ForeignKey(
    entity = Addresses::class,
    parentColumns = ["id_address"],
    childColumns = ["address_id"],
    onDelete = CASCADE
)]
    )
data class Application(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_application")
    val ID_Application: Int,
    @ColumnInfo("cabinet")
    val Cabinet: String,
    @ColumnInfo("department_id")
    val Department_ID: Int,
    @ColumnInfo("address_id")
    val Address: Int,
    @ColumnInfo("user_id")
    val User_ID: Int,
    @ColumnInfo("application_description")
    val Application_Description: String,
)
