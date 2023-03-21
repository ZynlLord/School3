package com.example.school.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.school.db.entities.Messages
import com.example.school.db.entities.Photo

@Dao
interface PhotoDAO : InsertDao<Photo>, UpdateDao<Photo>, DeleteDao<Photo> {
    @Query(
        """
        SELECT * FROM photo
    """
    )
    fun getAllPhotos(): LiveData<List<Photo>>
}