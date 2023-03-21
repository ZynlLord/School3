package com.example.school.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.school.db.entities.statics.Statuses

@Dao
interface StatusesDAO : InsertDao<Statuses>, UpdateDao<Statuses>, DeleteDao<Statuses> {

    @Query(
        """
        SELECT * FROM statuses_table
    """
    )
    fun getAllStatuses(): LiveData<List<Statuses>>
}