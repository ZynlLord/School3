package com.example.school.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "messages",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id_user"],
        childColumns = ["user_id"],
        onDelete = CASCADE
    )]
)
data class Messages(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_message")
    val ID_Message: Int,
    @ColumnInfo("message_text")
    val Message_Text: String,
    @ColumnInfo("user_id")
    val User_ID: Int,
    @ColumnInfo("send_date")
    val Send_Date: String,
)
