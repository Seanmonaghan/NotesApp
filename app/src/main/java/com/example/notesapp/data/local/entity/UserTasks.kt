package com.example.notesapp.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserTasks(
    @Embedded val user: User,

    @Relation(
        parentColumn = "id",
        entityColumn = "userID",
        entity = Task::class
    )
    val task: List<Task>
)