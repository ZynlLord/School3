package com.example.school.db.repository

import androidx.lifecycle.LiveData
import com.example.school.db.daos.*
import com.example.school.db.entities.*
import com.example.school.db.entities.statics.Addresses
import com.example.school.db.entities.statics.Departments
import com.example.school.db.entities.statics.Roles
import com.example.school.db.entities.statics.Statuses

class RoomRepository(
    private val userDAO: UserDAO,
    private val postDAO: PostDAO,
    private val photoDAO: PhotoDAO,
    private val messagesDAO: MessagesDAO,
    private val employeeDAO: EmployeeDAO,
    private val applicationHistoryDAO: ApplicationHistoryDAO,
    private val applicationDAO: ApplicationDAO,
    private val statusesDAO: StatusesDAO,
    private val rolesDAO: RolesDAO,
    private val departmentsDAO: DepartmentsDAO,
    private val addressesDAO: AddressesDAO
) : DatabaseRepository {


    override val readAllUsers: LiveData<List<User>>
        get() = userDAO.getAllUsers()

    override suspend fun createUser(user: User, onSuccess: () -> Unit) {
        userDAO.add(user)
        onSuccess()
    }

    override suspend fun updateUser(user: User, onSuccess: () -> Unit) {
        userDAO.update(user)
        onSuccess()
    }

    override suspend fun deleteUser(user: User, onSuccess: () -> Unit) {
        userDAO.delete(user)
        onSuccess()
    }

    override val readAllPost: LiveData<List<Post>>
        get() = postDAO.getAllPost()

    override suspend fun createPost(post: Post, onSuccess: () -> Unit) {
        postDAO.add(post)
        onSuccess()
    }

    override suspend fun updatePost(post: Post, onSuccess: () -> Unit) {
        postDAO.update(post)
        onSuccess()
    }

    override suspend fun deletePost(post: Post, onSuccess: () -> Unit) {
        postDAO.delete(post)
        onSuccess()
    }

    override val readAllPhoto: LiveData<List<Photo>>
        get() = photoDAO.getAllPhotos()

    override suspend fun createPhoto(photo: Photo, onSuccess: () -> Unit) {
        photoDAO.add(photo)
        onSuccess()
    }

    override suspend fun updatePhoto(photo: Photo, onSuccess: () -> Unit) {
        photoDAO.update(photo)
        onSuccess()
    }

    override suspend fun deletePhoto(photo: Photo, onSuccess: () -> Unit) {
        photoDAO.delete(photo)
        onSuccess()
    }

    override val readAllMessages: LiveData<List<Messages>>
        get() = messagesDAO.getAllMessages()

    override suspend fun createMessage(messages: Messages, onSuccess: () -> Unit) {
        messagesDAO.add(messages)
        onSuccess()
    }

    override suspend fun updateMessage(messages: Messages, onSuccess: () -> Unit) {
        messagesDAO.update(messages)
        onSuccess()
    }

    override suspend fun deleteMessage(messages: Messages, onSuccess: () -> Unit) {
        messagesDAO.delete(messages)
        onSuccess()
    }

    override val readAllEmployee: LiveData<List<Employee>>
        get() = employeeDAO.getAllEmployee()

    override suspend fun createEmployee(employee: Employee, onSuccess: () -> Unit) {
        employeeDAO.add(employee)
        onSuccess()
    }

    override suspend fun updateEmployee(employee: Employee, onSuccess: () -> Unit) {
        employeeDAO.update(employee)
        onSuccess()
    }

    override suspend fun deleteEmployee(employee: Employee, onSuccess: () -> Unit) {
        employeeDAO.delete(employee)
        onSuccess()
    }

    override val readAllApplication_History: LiveData<List<Application_History>>
        get() = applicationHistoryDAO.getAllApplicationHistory()

    override suspend fun createApplicationHistory(
        applicationHistory: Application_History,
        onSuccess: () -> Unit
    ) {
        applicationHistoryDAO.add(applicationHistory)
        onSuccess()
    }

    override suspend fun updateApplicationHistory(
        applicationHistory: Application_History,
        onSuccess: () -> Unit
    ) {
        applicationHistoryDAO.update(applicationHistory)
        onSuccess()
    }

    override suspend fun deleteApplicationHistory(
        applicationHistory: Application_History,
        onSuccess: () -> Unit
    ) {
        applicationHistoryDAO.delete(applicationHistory)
        onSuccess()
    }

    override val readAllApplication: LiveData<List<Application>>
        get() = applicationDAO.getAllApplications()

    override suspend fun createApplication(application: Application, onSuccess: () -> Unit) {
        applicationDAO.add(application)
        onSuccess()
    }

    override suspend fun updateApplication(application: Application, onSuccess: () -> Unit) {
        applicationDAO.update(application)
        onSuccess()
    }

    override suspend fun deleteApplication(application: Application, onSuccess: () -> Unit) {
        applicationDAO.delete(application)
        onSuccess()
    }

    override val readAllStatuses: LiveData<List<Statuses>>
        get() = statusesDAO.getAllStatuses()

    override suspend fun createStatus(statuses: Statuses, onSuccess: () -> Unit) {
        statusesDAO.add(statuses)
        onSuccess()
    }

    override suspend fun updateStatus(statuses: Statuses, onSuccess: () -> Unit) {
        statusesDAO.update(statuses)
        onSuccess()
    }

    override suspend fun deleteStatus(statuses: Statuses, onSuccess: () -> Unit) {
        statusesDAO.delete(statuses)
        onSuccess()
    }

    override val readAllRoles: LiveData<List<Roles>>
        get() = rolesDAO.getAllRoles()

    override suspend fun createRole(roles: Roles, onSuccess: () -> Unit) {
        rolesDAO.add(roles)
        onSuccess()
    }

    override suspend fun updateRole(roles: Roles, onSuccess: () -> Unit) {
        rolesDAO.update(roles)
        onSuccess()
    }

    override suspend fun deleteRole(roles: Roles, onSuccess: () -> Unit) {
        rolesDAO.delete(roles)
        onSuccess()
    }

    override val readAllDepartments: LiveData<List<Departments>>
        get() = departmentsDAO.getAllDepartments()

    override suspend fun createDepartment(departments: Departments, onSuccess: () -> Unit) {
        departmentsDAO.add(departments)
        onSuccess()
    }

    override suspend fun updateDepartment(departments: Departments, onSuccess: () -> Unit) {
        departmentsDAO.update(departments)
        onSuccess()
    }

    override suspend fun deleteDepartment(departments: Departments, onSuccess: () -> Unit) {
        departmentsDAO.delete(departments)
        onSuccess()
    }

    override val readAllAddresses: LiveData<List<Addresses>>
        get() = addressesDAO.getAllAddresses()

    override suspend fun createAddress(addresses: Addresses, onSuccess: () -> Unit) {
        addressesDAO.add(addresses)
        onSuccess()
    }

    override suspend fun updateAddress(addresses: Addresses, onSuccess: () -> Unit) {
        addressesDAO.update(addresses)
        onSuccess()
    }

    override suspend fun deleteAddress(addresses: Addresses, onSuccess: () -> Unit) {
        addressesDAO.delete(addresses)
        onSuccess()
    }

}