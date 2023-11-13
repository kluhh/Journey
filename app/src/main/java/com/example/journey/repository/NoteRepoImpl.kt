package com.example.journey.repository

import com.example.journey.data.NoteDao
import com.example.journey.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepoImpl(private val noteDao: NoteDao): NoteRepo
{
    override fun getNotes(): Flow<List<Note>>
    {
        return noteDao.getNotesFlow()
    }

    override fun getNote(noteId: Long): Flow<Note>
    {
        return noteDao.getNoteByIdFlow(noteId)
    }

    override suspend fun addNote(note: Note)
    {
        return noteDao.insertNote(note)
    }

    override suspend fun updateNote(note: Note)
    {
        return noteDao.updateNote(note)
    }

    override suspend fun deleteNote(noteId: Long)
    {
        return noteDao.deleteNoteById(noteId)
    }
}