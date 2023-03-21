package com.example.school.db.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.school.db.entities.User
import org.intellij.lang.annotations.Language

@Dao
interface UserDAO : InsertDao<User>, DeleteDao<User>, UpdateDao<User> {
    @Query(
        """
        SELECT * FROM users
        """
    )
    fun getAllUsers(): LiveData<List<User>>

    @Query(
        """
        SELECT * FROM users 
        WHERE id_user = :id
    """
    )
    suspend fun getUserById(id: Int): User

    @Query(
        """
        SELECT * FROM users
        WHERE user_login = :login
    """
    )
    suspend fun getUserByLogin(login: String): User?
}