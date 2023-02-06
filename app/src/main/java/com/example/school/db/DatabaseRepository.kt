package com.example.school.db

import androidx.lifecycle.LiveData

interface DatabaseRepository {
    val readAll: LiveData<List<User>>

    suspend fun create(user: User, onSuccess: () -> Unit)
    suspend fun update(user: User, onSuccess: () -> Unit)
    suspend fun delete(user: User, onSuccess: () -> Unit)


}