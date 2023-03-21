package com.example.school.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.school.db.entities.Messages

@Dao
interface MessagesDAO : InsertDao<Messages>, UpdateDao<Messages>, DeleteDao<Messages> {
    @Query(
        """
        SELECT * FROM messages
    """
    )
    fun getAllMessages(): LiveData<List<Messages>>
}