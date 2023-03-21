package com.example.school.db.entities

import androidx.compose.ui.semantics.Role
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.example.school.db.entities.statics.Roles

@Entity(tableName = "post",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id_user"],
            childColumns = ["user_id"],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Roles::class,
            parentColumns = ["id_role"],
            childColumns = ["role_id"],
            onDelete = CASCADE
        )
    ]
)
data class Post(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_post")
    val ID_Post: Int = 0,
    @ColumnInfo("user_id")
    val UserId: Int,
    @ColumnInfo("role_id")
    val RoleId: Int
)