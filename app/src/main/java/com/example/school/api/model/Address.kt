package com.example.school.api.model
import com.google.gson.annotations.SerializedName


data class Address(
    @SerializedName("idAddress")
    val idAddress: Int,
    @SerializedName("addressName")
    val addressName: String
)