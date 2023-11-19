package com.example.journey.ui.screens.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.journey.model.Task
import com.example.journey.ui.viewmodel.TaskViewModel
import java.time.LocalDate
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskDialog(onDismiss: () -> Unit)
{
    val viewModel: TaskViewModel = viewModel()

    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") } // If you have a description field
    var dueDate by remember { mutableStateOf(LocalDate.now()) }
    var isCompleted by remember { mutableStateOf(null) }
    val priority by remember { mutableStateOf(null) }


    AlertDialog(onDismissRequest = onDismiss, title = { Text("Add Task") }, text = {
        Column {
            TextField(value = taskTitle,
                onValueChange = { taskTitle = it },
                label = { Text("Task Title") })
            TextField(value = taskDescription,
                onValueChange = { taskDescription = it },
                label = { Text("Description") } // Optional if you have a description
            ) // Add more input fields as needed
        }
    }, confirmButton = {
        Button(onClick = { // Construct the Task object and add it using the ViewModel
            val newTask = Task(
                title = taskTitle,
                description = taskDescription,
                dueDate = dueDate,
                isCompleted = isCompleted,
                priority = priority
            )
            viewModel.addTask(newTask)
            onDismiss()
        }) {
            Text("Add")
        }
    }, dismissButton = {
        Button(onClick = onDismiss) {
            Text("Cancel")
        }
    })
}

