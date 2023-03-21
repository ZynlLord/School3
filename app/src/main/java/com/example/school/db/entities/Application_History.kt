package com.example.school.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.example.school.db.entities.statics.Statuses

@Entity(
    tableName = "application_history",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id_user"],
            childColumns = ["user_id"],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Statuses::class,
            parentColumns = ["id_status"],
            childColumns = ["status_id"],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Application::class,
            parentColumns = ["id_application"],
            childColumns = ["application_id"],
            onDelete = CASCADE
        )
    ]
)
data class Application_History(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_application_history")
    val ID_Application_History: Int,
    @ColumnInfo("application_change_date")
    val Application_Change_Date: String,
    @ColumnInfo("user_id")
    val User_ID: Int,
    @ColumnInfo("status_id")
    val Status_ID: Int,
    @ColumnInfo("application_id")
    val Application_ID: Int,
    @ColumnInfo("application_change_type")
    val Application_Change_Type: String,
)
