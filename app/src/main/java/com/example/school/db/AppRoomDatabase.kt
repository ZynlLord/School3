package com.example.school.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.school.db.daos.*
import com.example.school.db.entities.*
import com.example.school.db.entities.statics.Addresses
import com.example.school.db.entities.statics.Departments
import com.example.school.db.entities.statics.Roles
import com.example.school.db.entities.statics.Statuses
import com.example.school.utils.Constants

@Database(
    entities = [User::class, Post::class, Photo::class, Messages::class, Employee::class, Application_History::class,
        Application::class, Statuses::class, Roles::class, Departments::class, Addresses::class],
    version = 1
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDAO
    abstract fun getPostDao(): PostDAO
    abstract fun getPhotoDao(): PhotoDAO
    abstract fun getMessagesDao(): MessagesDAO
    abstract fun getEmployeeDao(): EmployeeDAO
    abstract fun getApplicationHistoryDao(): ApplicationHistoryDAO
    abstract fun getApplicationDao(): ApplicationDAO
    abstract fun getStatusesDao(): StatusesDAO
    abstract fun getRolesDao(): RolesDAO
    abstract fun getDepartmentsDao(): DepartmentsDAO
    abstract fun getAddressesDao(): AddressesDAO

    companion object {

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    Constants.Keys.DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE as AppRoomDatabase
            } else INSTANCE as AppRoomDatabase
        }
    }
}