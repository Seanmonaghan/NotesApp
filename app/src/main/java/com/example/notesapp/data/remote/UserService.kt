package com.example.notesapp.data.remote

import com.example.notesapp.data.local.entity.User
import com.example.notesapp.data.response.UserProfileDTO
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {
    companion object {
        fun newInstance(): UserService = Retrofit.retrofit.create()
    }

    //register
    @POST("/user/register")
    suspend fun registerUser(@Body user: User): UserProfileDTO

    //login
    @POST("/user/login")
    suspend fun loginUser(@Body user: User): UserProfileDTO

    //logout
    @POST("/user/logout")
    suspend fun logoutUser(@Header("Authorization") token: String)
}