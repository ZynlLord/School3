package com.example.school.api.model
import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("idUser")
    val idUser: Int,
    @SerializedName("userLogin")
    val userLogin: String,
    @SerializedName("userPassword")
    val userPassword: String,
    @SerializedName("userName")
    val userName: String,
    @SerializedName("userSurname")
    val userSurname: String,
    @SerializedName("userLastname")
    val userLastname: String,
    @SerializedName("userPhoneNumber")
    val userPhoneNumber: String,
    @SerializedName("userPhoto")
    val userPhoto: String
)