package com.example.school.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.school.db.entities.statics.Addresses


@Dao
interface AddressesDAO : InsertDao<Addresses>, UpdateDao<Addresses>, DeleteDao<Addresses> {

    @Query(
        """
        SELECT * FROM adresses_table
    """
    )
    fun getAllAddresses(): LiveData<List<Addresses>>
}