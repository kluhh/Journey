package com.example.journey.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.journey.model.Event
import com.example.journey.ui.viewmodel.EventsViewModel

@Composable
fun EventsScreen() {
    val viewModel: EventsViewModel = viewModel()
    val events = viewModel.events.collectAsState().value

    // UI to display events
    LazyColumn {
        items(events) { event ->
            EventItem(event, onEventClicked = { /* Handle event click */ })
        }
    }
}

@Composable
fun EventItem(event: Event, onEventClicked: (Event) -> Unit) {
    // Layout for each event item
    Text(text = event.title, modifier = Modifier.clickable { onEventClicked(event) })
    // Add more details as needed
}
