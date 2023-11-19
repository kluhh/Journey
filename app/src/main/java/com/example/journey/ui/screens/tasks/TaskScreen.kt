package com.example.journey.ui.screens.tasks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.journey.model.Task
import com.example.journey.ui.viewmodel.TaskViewModel

@Composable
fun TasksScreen() {

    val viewModel: TaskViewModel = viewModel()

    val tasks = viewModel.tasks.collectAsState().value

    val showDialog = remember { mutableStateOf(false) }

    Column {
        AddTaskButton(onAddClicked = { showDialog.value = true })
        if (showDialog.value) {
            AddTaskDialog() {
                // Dismiss the dialog when the task is added or when dismissed
                showDialog.value = false
            }
        }

        LazyColumn {
            items(tasks) { task ->
                TaskItem(task, onTaskClicked = { /* Handle task click */ })
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, onTaskClicked: (Task) -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onTaskClicked(task) }
        .padding(16.dp)) {
        Text(text = task.title, style = MaterialTheme.typography.headlineSmall)
        // Add more UI elements as needed (e.g., checkbox, delete button)
    }
}

@Composable
fun AddTaskButton(onAddClicked: () -> Unit) {
    Button(onClick = onAddClicked) {
        Text("Add Task")
    }
}
