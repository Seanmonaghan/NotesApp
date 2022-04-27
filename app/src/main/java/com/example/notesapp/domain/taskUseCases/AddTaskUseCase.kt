package com.example.notesapp.domain.taskUseCases

import com.example.notesapp.data.local.entity.Task
import com.example.notesapp.data.repo.TasksRepo
import org.koin.java.KoinJavaComponent.inject

class AddTaskUseCase {
    private val repo: TasksRepo by inject(TasksRepo::class.java)

    suspend operator fun invoke(token: String, newTask: Task): Boolean {
        return try {
            repo.addTask(token, newTask)
        } catch (ex: Exception) {
            false
        }
    }
}