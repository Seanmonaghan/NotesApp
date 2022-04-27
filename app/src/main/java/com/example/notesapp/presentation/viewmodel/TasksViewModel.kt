package com.example.notesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.local.entity.Task
import com.example.notesapp.domain.taskUseCases.AddTaskUseCase
import com.example.notesapp.domain.taskUseCases.DeleteTaskUseCase
import com.example.notesapp.domain.taskUseCases.GetAllTasksUseCase
import com.example.notesapp.domain.taskUseCases.UpdateTaskUseCase
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

//params -> list of usecases
class TasksViewModel : ViewModel() {

    private val getAllTasksUseCase: GetAllTasksUseCase by inject(GetAllTasksUseCase::class.java)
    private val addTaskUseCase: AddTaskUseCase by inject(AddTaskUseCase::class.java)
    private val updateTaskUseCase: UpdateTaskUseCase by inject(UpdateTaskUseCase::class.java)
    private val deleteTaskUseCase: DeleteTaskUseCase by inject(DeleteTaskUseCase::class.java)

    fun getAllTasks(token: String, userId: Int) = viewModelScope.launch {
        getAllTasksUseCase(token, userId)
    }

    fun addTask(token: String, task: Task) = viewModelScope.launch {
        addTaskUseCase(token, task)
    }

    fun updateTask(token: String, task: Task) = viewModelScope.launch {
        updateTaskUseCase(token, task)
    }

    fun deleteTask(token:String, task:Task) = viewModelScope.launch {
        deleteTaskUseCase(token, task)
    }

}