package com.example.school.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.school.db.entities.Application

@Dao
interface ApplicationDAO : InsertDao<Application>, UpdateDao<Application>, DeleteDao<Application> {
    @Query(
        """
        SELECT * FROM application_table
    """
    )
    fun getAllApplications(): LiveData<List<Application>>
}