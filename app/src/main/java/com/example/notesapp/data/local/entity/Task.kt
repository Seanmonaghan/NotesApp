package com.example.notesapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tasks")
data class Task(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val userID: Int,
    val description: String,
    val completed: Boolean
)
