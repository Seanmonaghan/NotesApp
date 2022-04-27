package com.example.notesapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.data.local.dao.TaskDao
import com.example.notesapp.data.local.dao.UserDao
import com.example.notesapp.data.local.entity.Task
import com.example.notesapp.data.local.entity.User

@Database(entities = [Task::class, User::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
    abstract fun userDao(): UserDao

    companion object {
        private const val DB_NAME = "Notes.db"
        @Volatile
        private var instance: NotesDatabase? = null

        private fun databaseBuilder(context: Context): NotesDatabase = Room.databaseBuilder(
            context, NotesDatabase::class.java, DB_NAME
        ).build()

        fun getInstance(context: Context): NotesDatabase {
            return instance ?: synchronized(this) {
                instance ?: databaseBuilder(context).also {
                    instance = it
                }
            }
        }

    }
}