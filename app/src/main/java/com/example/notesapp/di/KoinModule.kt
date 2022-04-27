package com.example.notesapp.di

import com.example.notesapp.data.local.NotesDatabase
import com.example.notesapp.data.remote.TasksService
import com.example.notesapp.data.remote.UserService
import com.example.notesapp.data.repo.TasksRepo
import com.example.notesapp.data.repo.UserRepo
import com.example.notesapp.domain.userUserCases.RegisterUserUseCase
import org.koin.dsl.module

object KoinModule {

    val appModule = module {
        //services
        single { TasksService.newInstance() }
        single { UserService.newInstance() }

        //daos
        single { NotesDatabase.getInstance(get()).userDao() }
        single { NotesDatabase.getInstance(get()).taskDao() }

        //repo
        single { TasksRepo() }
        single { UserRepo() }

        //useCases
        single { RegisterUserUseCase() }


        factory { KoinModule }
    }

}