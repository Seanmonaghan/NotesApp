package com.example.notesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.local.entity.User
import com.example.notesapp.domain.userUserCases.LoginUserUseCase
import com.example.notesapp.domain.userUserCases.LogoutUserUseCase
import com.example.notesapp.domain.userUserCases.RegisterUserUseCase
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class UsersViewModel : ViewModel() {

    private val registerUseCase: RegisterUserUseCase by inject(RegisterUserUseCase::class.java)
    private val loginUseCase: LoginUserUseCase by inject(LoginUserUseCase::class.java)
    private val logoutUseCase: LogoutUserUseCase by inject(LogoutUserUseCase::class.java)

    fun registerUser(user: User) = viewModelScope.launch {
        registerUseCase(user)
    }

    fun loginUser(user: User) = viewModelScope.launch {
        loginUseCase(user)
    }

    fun logoutUser(token: String) = viewModelScope.launch {
        logoutUseCase(token)
    }
}