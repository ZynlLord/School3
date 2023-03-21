package com.example.school.db.entities.statics

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.school.utils.Constants.Statuses.STATUSES_TABLE
import com.example.school.utils.Constants.Statuses.STATUS_ID
import com.example.school.utils.Constants.Statuses.STATUS_NAME

@Entity(STATUSES_TABLE)
data class Statuses(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_status")
    val ID_Status: Int = 0,
    @ColumnInfo(STATUS_NAME)
    val Status_Name: String,
)
