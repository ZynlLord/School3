package com.example.school.api.model
import com.google.gson.annotations.SerializedName


data class Department(
    @SerializedName("idDepartment")
    val idDepartment: Int,
    @SerializedName("departmentName")
    val departmentName: String
)