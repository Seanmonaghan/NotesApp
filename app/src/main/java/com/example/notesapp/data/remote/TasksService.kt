package com.example.notesapp.data.remote

import com.example.notesapp.data.local.entity.Task
import com.example.notesapp.data.response.SuccessDTO
import com.example.notesapp.data.response.TaskListDTO
import retrofit2.create
import retrofit2.http.*

interface TasksService {
    companion object {
        fun newInstance(): TasksService = Retrofit.retrofit.create()
    }

    //getAll
    @GET("/task")
    suspend fun getAllTasks(@Header("Authorization") token: String): TaskListDTO

    //create todos
    @POST("/task")
    suspend fun addTask(@Header("Authorization") token: String, @Body task: Task): SuccessDTO

    //update todos
    @PUT("/task/{id}")
    suspend fun updateTask(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Body task: Task
    ): SuccessDTO

    //delete todos
    @DELETE("/task/{id}")
    suspend fun deleteTask(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): SuccessDTO
}