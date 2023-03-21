package com.example.school.api.model
import com.google.gson.annotations.SerializedName


data class Status(
    @SerializedName("idStatus")
    val idStatus: Int,
    @SerializedName("statusName")
    val statusName: String
)