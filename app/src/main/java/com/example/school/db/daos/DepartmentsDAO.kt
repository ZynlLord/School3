package com.example.school.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.school.db.entities.statics.Departments


@Dao
interface DepartmentsDAO : InsertDao<Departments>, UpdateDao<Departments>, DeleteDao<Departments> {

    @Query(
        """
        SELECT * FROM departments_table
    """
    )
    fun getAllDepartments(): LiveData<List<Departments>>
}