package com.example.journey.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.journey.model.Task
import com.example.journey.repository.TaskRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val taskRepo: TaskRepo) : ViewModel()
{
    // Private MutableStateFlow for internal updates
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())

    // Publicly exposed as read-only StateFlow
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    private val _selectedTask = MutableStateFlow<Task?>(null)

    val selectedTask: StateFlow<Task?> = _selectedTask.asStateFlow()

    init
    {
        loadTasks()
    }


    /**
     * Function to collect the flow list of task and assign it to the internal state holder
     */
    private fun loadTasks()
    {
        viewModelScope.launch {
            taskRepo.getTasks().collect { listOfTasks ->
                _tasks.value = listOfTasks
            }
        }
    }

    /**
     * Function to add a new task
     * @param task new task to add
     */
    fun addTask(task: Task)
    {
        viewModelScope.launch {
            taskRepo.addTask(task)
            loadTasks() // Refresh the list after adding
        }
    }

    /**
     * Function to update an existing task
     * @param task task to update
     */
    fun updateTask(task: Task)
    {
        viewModelScope.launch {
            taskRepo.updateTask(task)
            loadTasks() // Refresh the list after updating
        }
    }

    /**
     * Function to update an existing task
     * @param taskId number id for specific task
     */
    fun deleteTask(taskId: Long)
    {
        viewModelScope.launch {
            taskRepo.deleteTask(taskId)
            loadTasks() // Refresh the list after deleting
        }
    }


}