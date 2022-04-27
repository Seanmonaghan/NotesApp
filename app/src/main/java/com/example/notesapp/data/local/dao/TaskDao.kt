package com.example.notesapp.data.local.dao

import androidx.room.*
import com.example.notesapp.data.local.entity.Task
import com.example.notesapp.data.local.entity.UserTasks

@Dao
interface TaskDao {

    @Transaction
    @Query("SELECT * FROM Tasks WHERE userID = :userID")
    suspend fun getAllTasksByUser(userID: Int): UserTasks

    @Insert(entity = Task::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(vararg task: Task)

    @Delete(entity = Task::class)
    suspend fun delete(task: Task)
}