package com.example.school.api.model
import com.google.gson.annotations.SerializedName


data class Message(
    @SerializedName("idMessage")
    val idMessage: Int,
    @SerializedName("messageText")
    val messageText: String,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("sendDate")
    val sendDate: String
)