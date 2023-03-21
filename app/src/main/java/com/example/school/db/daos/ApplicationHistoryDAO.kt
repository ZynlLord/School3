package com.example.school.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.school.db.entities.Application_History

@Dao
interface ApplicationHistoryDAO : InsertDao<Application_History>, UpdateDao<Application_History>,
    DeleteDao<Application_History> {
    @Query(
        """
        SELECT * FROM application_history
    """
    )
    fun getAllApplicationHistory(): LiveData<List<Application_History>>

}
