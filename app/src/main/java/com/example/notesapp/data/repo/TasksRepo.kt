package com.example.notesapp.data.repo

import com.example.notesapp.data.local.dao.TaskDao
import com.example.notesapp.data.local.entity.Task
import com.example.notesapp.data.remote.TasksService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject

class TasksRepo {

    private val service: TasksService by inject(TasksService::class.java)
    private val taskDao: TaskDao by inject(TaskDao::class.java)


    //getAll
    suspend fun getAllTasks(token: String, userId: Int): List<Task> =
        withContext(Dispatchers.IO) {
            return@withContext taskDao.getAllTasksByUser(userId)
                .task.ifEmpty {
                    val tasks = service.getAllTasks(token).data.map {
                        Task(
                            id = it.id,
                            description = it.description,
                            completed = it.completed,
                            userID = userId
                        )
                    }
                    taskDao.insertTask(*tasks.toTypedArray())
                    return@ifEmpty tasks
                }
        }

    //create todos
    suspend fun addTask(token: String, task: Task): Boolean = withContext(Dispatchers.IO) {
        val result = service.addTask(token, task).success
        taskDao.insertTask(task)
        result
    }

    //update todos
    suspend fun updateTask(token: String, task: Task): Boolean =
        withContext(Dispatchers.IO) {
            val result = service.updateTask(token, task.id, task).success
            taskDao.insertTask(task)
            result
        }

    //delete todos
    suspend fun deleteTask(token: String, task: Task): Boolean = withContext(Dispatchers.IO) {
        val result = service.deleteTask(token, task.id).success
        taskDao.delete(task)
        result
    }

}