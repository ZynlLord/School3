package com.example.school.db.repository

import androidx.lifecycle.LiveData
import com.example.school.db.DatabaseRepository
import com.example.school.db.User
import com.example.school.db.UserDAO

class RoomRepository(private val  userDAO: UserDAO): DatabaseRepository {
    override val readAll: LiveData<List<User>>
        get() = userDAO.getAll()

    override suspend fun create(user: User, onSuccess: () -> Unit) {
        userDAO.addUser(user = user)
        onSuccess()
    }

    override suspend fun update(user: User, onSuccess: () -> Unit) {
        userDAO.updateUser(user = user)
        onSuccess()
    }

    override suspend fun delete(user: User, onSuccess: () -> Unit) {
        userDAO.deleteUser(user = user)
        onSuccess()
    }

}