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
import com.example.journey.model.Note
import com.example.journey.ui.viewmodel.NotesViewModel

@Composable
fun NoteScreen() {
    val viewModel: NotesViewModel = viewModel()
    val notes = viewModel.notes.collectAsState().value

    // UI to display events
    LazyColumn {
        items(notes) { note ->
            NoteItem(note, onNoteClicked = { /* Handle event click */ })
        }
    }
}

@Composable
fun NoteItem(note: Note, onNoteClicked: (Note) -> Unit) {
    // Layout for each event item
    Text(text = note.title, modifier = Modifier.clickable { onNoteClicked(note) })
    // Add more details as needed
}