package com.example.school.api.model
import com.google.gson.annotations.SerializedName


data class Application(
    @SerializedName("idApplication")
    val idApplication: Int,
    @SerializedName("cabinet")
    val cabinet: String,
    @SerializedName("departmentId")
    val departmentId: Int,
    @SerializedName("addressId")
    val addressId: Int,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("applicationDescription")
    val applicationDescription: String
)