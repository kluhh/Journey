package com.example.journey.data

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.journey.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteDao
{
    @Query("SELECT * FROM notes")
    fun getNotesFlow(): Flow<List<Note>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    fun getNoteByIdFlow(noteId:Long): Flow<Note>

    @Insert
    suspend fun insertNote(note:Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("DELETE FROM notes WHERE id = :noteId")
    suspend fun deleteNoteById(noteId: Long)
}