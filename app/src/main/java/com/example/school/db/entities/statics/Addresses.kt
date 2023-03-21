package com.example.school.db.entities.statics

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.school.utils.Constants.Addresses.ADDRESSES_ID
import com.example.school.utils.Constants.Addresses.ADDRESSES_NAME
import com.example.school.utils.Constants.Addresses.ADDRESSES_TABLE

@Entity(ADDRESSES_TABLE)
data class Addresses(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_address")
    val Address_ID: Int = 0,
    @ColumnInfo(ADDRESSES_NAME)
    val Address_Name: String,
)
