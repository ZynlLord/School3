package com.example.school.api.model
import com.google.gson.annotations.SerializedName


data class Role(
    @SerializedName("idRole")
    val idRole: Int,
    @SerializedName("roleName")
    val roleName: String
)