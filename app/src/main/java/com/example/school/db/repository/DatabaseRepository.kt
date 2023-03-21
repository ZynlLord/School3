package com.example.school.db.repository

import androidx.lifecycle.LiveData
import com.example.school.db.entities.*
import com.example.school.db.entities.statics.Addresses
import com.example.school.db.entities.statics.Departments
import com.example.school.db.entities.statics.Roles
import com.example.school.db.entities.statics.Statuses

interface DatabaseRepository {

    val readAllUsers: LiveData<List<User>>

    suspend fun createUser(user: User, onSuccess: () -> Unit)
    suspend fun updateUser(user: User, onSuccess: () -> Unit)
    suspend fun deleteUser(user: User, onSuccess: () -> Unit)

    val readAllPost: LiveData<List<Post>>

    suspend fun createPost(post: Post, onSuccess: () -> Unit)
    suspend fun updatePost(post: Post, onSuccess: () -> Unit)
    suspend fun deletePost(post: Post, onSuccess: () -> Unit)

    val readAllPhoto: LiveData<List<Photo>>

    suspend fun createPhoto(photo: Photo, onSuccess: () -> Unit)
    suspend fun updatePhoto(photo: Photo, onSuccess: () -> Unit)
    suspend fun deletePhoto(photo: Photo, onSuccess: () -> Unit)


    val readAllMessages: LiveData<List<Messages>>

    suspend fun createMessage(messages: Messages, onSuccess: () -> Unit)
    suspend fun updateMessage(messages: Messages, onSuccess: () -> Unit)
    suspend fun deleteMessage(messages: Messages, onSuccess: () -> Unit)

    val readAllEmployee: LiveData<List<Employee>>

    suspend fun createEmployee(employee: Employee, onSuccess: () -> Unit)
    suspend fun updateEmployee(employee: Employee, onSuccess: () -> Unit)
    suspend fun deleteEmployee(employee: Employee, onSuccess: () -> Unit)

    val readAllApplication_History: LiveData<List<Application_History>>

    suspend fun createApplicationHistory(applicationHistory: Application_History, onSuccess: () -> Unit)
    suspend fun updateApplicationHistory(applicationHistory: Application_History, onSuccess: () -> Unit)
    suspend fun deleteApplicationHistory(applicationHistory: Application_History, onSuccess: () -> Unit)

    val readAllApplication: LiveData<List<Application>>

    suspend fun createApplication(application: Application, onSuccess: () -> Unit)
    suspend fun updateApplication(application: Application, onSuccess: () -> Unit)
    suspend fun deleteApplication(application: Application, onSuccess: () -> Unit)

    val readAllStatuses: LiveData<List<Statuses>>

    suspend fun createStatus(statuses: Statuses, onSuccess: () -> Unit)
    suspend fun updateStatus(statuses: Statuses, onSuccess: () -> Unit)
    suspend fun deleteStatus(statuses: Statuses, onSuccess: () -> Unit)

    val readAllRoles: LiveData<List<Roles>>

    suspend fun createRole(roles: Roles, onSuccess: () -> Unit)
    suspend fun updateRole(roles: Roles, onSuccess: () -> Unit)
    suspend fun deleteRole(roles: Roles, onSuccess: () -> Unit)

    val readAllDepartments: LiveData<List<Departments>>

    suspend fun createDepartment(departments: Departments, onSuccess: () -> Unit)
    suspend fun updateDepartment(departments: Departments, onSuccess: () -> Unit)
    suspend fun deleteDepartment(departments: Departments, onSuccess: () -> Unit)

    val readAllAddresses: LiveData<List<Addresses>>

    suspend fun createAddress(addresses: Addresses, onSuccess: () -> Unit)
    suspend fun updateAddress(addresses: Addresses, onSuccess: () -> Unit)
    suspend fun deleteAddress(addresses: Addresses, onSuccess: () -> Unit)

}