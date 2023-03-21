package com.example.school.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.school.db.AppRoomDatabase
import com.example.school.db.entities.*
import com.example.school.db.entities.statics.Addresses
import com.example.school.db.entities.statics.Departments
import com.example.school.db.entities.statics.Roles
import com.example.school.db.entities.statics.Statuses
import com.example.school.db.repository.RoomRepository
import com.example.school.utils.REPOSITORY
import com.example.school.utils.TYPE_ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        Log.d("checkdata", "MainViewModel init database with type $type")
        when (type) {
            TYPE_ROOM -> {
                val userDAO = AppRoomDatabase.getInstance(context = context).getUserDao()
                val postDAO = AppRoomDatabase.getInstance(context = context).getPostDao()
                val photoDAO = AppRoomDatabase.getInstance(context = context).getPhotoDao()
                val messagesDAO = AppRoomDatabase.getInstance(context = context).getMessagesDao()
                val employeeDAO = AppRoomDatabase.getInstance(context = context).getEmployeeDao()
                val applicationhistoryDAO =
                    AppRoomDatabase.getInstance(context = context).getApplicationHistoryDao()
                val applicationDAO =
                    AppRoomDatabase.getInstance(context = context).getApplicationDao()
                val statusesDAO = AppRoomDatabase.getInstance(context = context).getStatusesDao()
                val rolesDAO = AppRoomDatabase.getInstance(context = context).getRolesDao()
                val departmentsDAO =
                    AppRoomDatabase.getInstance(context = context).getDepartmentsDao()
                val addressesDAO = AppRoomDatabase.getInstance(context = context).getAddressesDao()
                REPOSITORY = RoomRepository(
                    userDAO,
                    postDAO,
                    photoDAO,
                    messagesDAO,
                    employeeDAO,
                    applicationhistoryDAO,
                    applicationDAO,
                    statusesDAO,
                    rolesDAO,
                    departmentsDAO,
                    addressesDAO
                )
                onSuccess()
            }
        }

    }

    fun addUser(user: User, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createUser(user = user) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllUsers() = REPOSITORY.readAllUsers

    fun updateUser(user: User, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updateUser(user = user) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteUser(user: User, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteUser(user = user) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun addPost(post: Post, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createPost(post = post) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllPosts() = REPOSITORY.readAllPost

    fun updatePost(post: Post, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updatePost(post = post) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deletePost(post: Post, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deletePost(post) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun addPhoto(photo: Photo, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createPhoto(photo) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllPhotos() = REPOSITORY.readAllPhoto

    fun updatePhoto(photo: Photo, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updatePhoto(photo) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deletePhoto(photo: Photo, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deletePhoto(photo) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun addMessages(messages: Messages, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createMessage(messages) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllMessages() = REPOSITORY.readAllMessages

    fun updateMessage(messages: Messages, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updateMessage(messages) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteMessage(messages: Messages, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteMessage(messages) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun addEmployee(employee: Employee, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createEmployee(employee) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllEmployee() = REPOSITORY.readAllEmployee

    fun updateEmployee(employee: Employee, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updateEmployee(employee) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteEmployee(employee: Employee, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteEmployee(employee) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun addApplicationHistory(applicationHistory: Application_History, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createApplicationHistory(applicationHistory) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllApplicationHistory() = REPOSITORY.readAllApplication_History

    fun updateApplicationHistory(applicationHistory: Application_History, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updateApplicationHistory(applicationHistory) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteApplicationHistory(applicationHistory: Application_History, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteApplicationHistory(applicationHistory) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun addApplication(
        application: com.example.school.db.entities.Application,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createApplication(application) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllApplication() = REPOSITORY.readAllApplication

    fun updateApplication(
        application: com.example.school.db.entities.Application,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updateApplication(application) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteApplication(
        application: com.example.school.db.entities.Application,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteApplication(application) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun addStatuses(statuses: Statuses, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createStatus(statuses) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllStatuses() = REPOSITORY.readAllStatuses

    fun updateStatus(statuses: Statuses, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updateStatus(statuses) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteStatuses(statuses: Statuses, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteStatus(statuses) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun addRoles(roles: Roles, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createRole(roles) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllRoles() = REPOSITORY.readAllRoles

    fun updateRoles(roles: Roles, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updateRole(roles) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteRoles(roles: Roles, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteRole(roles) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun addDepartments(departments: Departments, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createDepartment(departments) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllDepartments() = REPOSITORY.readAllDepartments

    fun updateDepartments(departments: Departments, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updateDepartment(departments) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteDepartments(departments: Departments, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteDepartment(departments) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun addAddress(addresses: Addresses, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.createAddress(addresses) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllAddresses() = REPOSITORY.readAllAddresses

    fun updateAddress(addresses: Addresses, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updateAddress(addresses) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteAddress(addresses: Addresses, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteAddress(addresses) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }


}


class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }
}