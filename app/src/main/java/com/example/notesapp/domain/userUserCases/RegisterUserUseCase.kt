package com.example.notesapp.domain.userUserCases

import com.example.notesapp.data.local.entity.User
import com.example.notesapp.data.repo.UserRepo
import com.example.notesapp.presentation.ui.fragments.UserState
import org.koin.java.KoinJavaComponent.inject

class RegisterUserUseCase {
    private val repo: UserRepo by inject(UserRepo::class.java)

    suspend operator fun invoke(newUser: User): Result<UserState> {
        return try {
            val result = repo.registerUser(newUser)
            Result.success(
                UserState(
                    user = result,
                    isAcceptableEmail = !result.email.isNullOrBlank()
                )
            )
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }
}