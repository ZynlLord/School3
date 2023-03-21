package com.example.school.api

import com.example.school.api.model.*
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("Users")
    fun getUsers(): Call<List<User>>

    @GET("Statuses")
    fun getStatuses(): Call<List<Status>>

    @GET("Roles")
    fun getRoles(): Call<List<Role>>

    @GET("Posts")
    fun getPosts(): Call<List<Post>>

    @GET("Photos")
    fun getPhotos(): Call<List<Photo>>

    @GET("Messages")
    fun getMessages(): Call<List<Message>>

    @GET("Employees")
    fun getEmployees(): Call<List<Employee>>

    @GET("Departments")
    fun getDepartments(): Call<List<Department>>

    @GET("ApplicationHistories")
    fun getApplicationHistories(): Call<List<ApplicationHistory>>

    @GET("Applications")
    fun getApplications(): Call<List<Application>>

    @GET("Addresses")
    fun getAddresses(): Call<List<Address>>

}