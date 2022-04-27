package com.example.notesapp.data.repo

import com.example.notesapp.data.local.dao.UserDao
import com.example.notesapp.data.local.entity.User
import com.example.notesapp.data.remote.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject

class UserRepo {
    private val service: UserService by inject(UserService::class.java)
    private val userDao: UserDao by inject(UserDao::class.java)


    //register
    suspend fun registerUser(user: User): User = withContext(Dispatchers.IO) {
        val currentUser = userDao.getUserById(user.id)
        currentUser?.let {
            return@withContext it
        }

        val profile = service.registerUser(user)
        user.token = profile.token
        if (currentUser?.id == null) return@withContext user
        userDao.insertUser(user)
        user
    }

    //login
    suspend fun loginUser(user: User): User = withContext(Dispatchers.IO) {
        val profile = service.loginUser(user)
        val newUser = User(
            age = profile.user.age,
            name = profile.user.name,
            email = profile.user.email,
            password = profile.user.password,
            token = profile.token
        )
        userDao.insertUser(newUser)
        newUser
    }

    //logout
    suspend fun logoutUser(token: String) = withContext(Dispatchers.IO) {
        service.logoutUser(token)
    }
}