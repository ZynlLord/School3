package com.example.school.api.model
import com.google.gson.annotations.SerializedName


data class Post(
    @SerializedName("idPost")
    val idPost: Int,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("roleId")
    val roleId: Int
)