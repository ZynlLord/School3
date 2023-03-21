package com.example.school.api.model
import com.google.gson.annotations.SerializedName


data class Photo(
    @SerializedName("idPhoto")
    val idPhoto: Int,
    @SerializedName("typePhoto")
    val typePhoto: String,
    @SerializedName("messageId")
    val messageId: Int,
    @SerializedName("photoLink")
    val photoLink: String
)