package com.example.school.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "Photo", foreignKeys = [ForeignKey(
        entity = Messages::class,
        parentColumns = ["id_message"],
        childColumns = ["message_id"],
        onDelete = CASCADE
    )]
)
data class Photo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_photo")
    val ID_Photo: Int,
    @ColumnInfo("type_photo")
    val Type_Photo: String,
    @ColumnInfo("photo_link")
    val Photo_Link: String,
    @ColumnInfo("message_id")
    val Message_ID: Int,
)
