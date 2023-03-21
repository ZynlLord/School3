package com.example.school.api.model
import com.google.gson.annotations.SerializedName


data class Employee(
    @SerializedName("idEmployee")
    val idEmployee: Int,
    @SerializedName("departmentId")
    val departmentId: Int,
    @SerializedName("userId")
    val userId: Int
)