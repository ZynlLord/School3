package com.example.school.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.school.db.entities.statics.Roles


@Dao
interface RolesDAO : InsertDao<Roles>, UpdateDao<Roles>, DeleteDao<Roles> {
    @Query(
        """
        SELECT * FROM roles_table
    """
    )
    fun getAllRoles(): LiveData<List<Roles>>

}