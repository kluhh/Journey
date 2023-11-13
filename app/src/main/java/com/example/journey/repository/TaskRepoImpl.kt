package com.example.journey.repository

import com.example.journey.data.TaskDao
import com.example.journey.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepoImpl(private val taskDao: TaskDao) : TaskRepo {

    override fun getTasks(): Flow<List<Task>>
    {
        // Fetching a list of tasks as a Flow from the database
        return taskDao.getTasksFlow()
    }

    override fun getTask(taskId: Long): Flow<Task> {
        // Fetching a single task by ID as a Flow
        return taskDao.getTaskByIdFlow(taskId)
    }

    override suspend fun addTask(task: Task) {
        // Inserting a task into the database
        taskDao.insertTask(task)
    }

    override suspend fun updateTask(task: Task) {
        // Updating a task in the database
        taskDao.updateTask(task)
    }

    override suspend fun deleteTask(taskId: Long) {
        // Deleting a task from the database
        taskDao.deleteTaskById(taskId)
    }
}
