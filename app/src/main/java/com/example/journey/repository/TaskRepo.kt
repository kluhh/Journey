package com.example.journey.repository

import com.example.journey.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepo {
    fun getTasks(): Flow<List<Task>>
    fun getTask(taskId: Long): Flow<Task>
    suspend fun addTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(taskId: Long)
}
