package com.example.school.api.model
import com.google.gson.annotations.SerializedName


data class ApplicationHistory(
    @SerializedName("idApplicationHistory")
    val idApplicationHistory: Int,
    @SerializedName("applicationChangeDate")
    val applicationChangeDate: String,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("statusId")
    val statusId: Int,
    @SerializedName("applicationId")
    val applicationId: Int,
    @SerializedName("applicationChangeType")
    val applicationChangeType: String
)