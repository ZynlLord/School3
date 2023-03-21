package com.example.school.db.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface UpdateDao<T> {
    @Update
    suspend fun update(obj: T)
}

interface DeleteDao<T> {
    @Delete
    suspend fun delete(obj: T)
}

interface InsertDao<T> {
    @Insert
    suspend fun add(vararg obj: T)
}