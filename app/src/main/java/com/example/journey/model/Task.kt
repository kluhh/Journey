package com.example.journey.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String?,
    val dueDate: LocalDate?,
    val priority: TaskPriority?,
    val isCompleted: Boolean?,
    val categoryId: Long? = null// Foreign key to Category

)

enum class TaskPriority {
    HIGH, MEDIUM, LOW
}
