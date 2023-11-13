package com.example.journey.repository

import com.example.journey.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepo
{
    fun getNotes(): Flow<List<Note>>
    fun getNote(noteId: Long): Flow<Note>
    suspend fun addNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(noteId: Long)
    // Additional methods as needed, e.g., getting notes linked to a specific task or event
}