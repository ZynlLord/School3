package com.example.school.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.school.db.entities.Post

@Dao
interface PostDAO : InsertDao<Post>, UpdateDao<Post>, DeleteDao<Post> {
    @Query(
        """
        SELECT * FROM post
    """
    )
    fun getAllPost(): LiveData<List<Post>>
}