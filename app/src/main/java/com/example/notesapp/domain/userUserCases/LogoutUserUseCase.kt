package com.example.notesapp.domain.userUserCases

import com.example.notesapp.data.repo.UserRepo
import org.koin.java.KoinJavaComponent.inject

class LogoutUserUseCase {

    private val repo: UserRepo by inject(UserRepo::class.java)

    suspend operator fun invoke(token: String) {
        repo.logoutUser(token)
    }
}