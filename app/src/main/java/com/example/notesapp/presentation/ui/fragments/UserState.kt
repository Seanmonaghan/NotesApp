package com.example.notesapp.presentation.ui.fragments

import com.example.notesapp.data.local.entity.User

data class UserState(
    var isAcceptableEmail: Boolean = false,
    var user: User? = null,
    var isLoading:Boolean = false,
    var errorMsg: String? = null
)