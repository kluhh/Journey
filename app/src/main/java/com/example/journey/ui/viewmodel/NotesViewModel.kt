package com.example.journey.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.journey.model.Note
import com.example.journey.repository.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteRepo: NoteRepo) : ViewModel() {

    // StateFlow for the list of notes
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    // StateFlow for a selected note
    private val _selectedNote = MutableStateFlow<Note?>(null)
    val selectedNote: StateFlow<Note?> = _selectedNote.asStateFlow()

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch {
            noteRepo.getNotes().collect { listOfNotes ->
                _notes.value = listOfNotes
            }
        }
    }

    fun getNote(noteId: Long) {
        viewModelScope.launch {
            noteRepo.getNote(noteId).collect { note ->
                _selectedNote.value = note
            }
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            noteRepo.addNote(note)
            loadNotes() // Refresh the list
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteRepo.updateNote(note)
            loadNotes() // Refresh the list
        }
    }

    fun deleteNote(noteId: Long) {
        viewModelScope.launch {
            noteRepo.deleteNote(noteId)
            loadNotes() // Refresh the list
        }
    }

    // Additional methods as needed
}