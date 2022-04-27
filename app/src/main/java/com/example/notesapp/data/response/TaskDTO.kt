package com.example.notesapp.data.response

import com.google.gson.annotations.SerializedName

data class TaskDTO(
    @SerializedName("_id")
    val id: String,
    val description: String,
    val completed: Boolean
)
