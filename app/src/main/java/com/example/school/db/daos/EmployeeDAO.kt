package com.example.school.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.school.db.entities.Employee

@Dao
interface EmployeeDAO : InsertDao<Employee>, UpdateDao<Employee>, DeleteDao<Employee> {
    @Query(
        """
        SELECT * FROM employee
    """
    )
    fun getAllEmployee(): LiveData<List<Employee>>
}