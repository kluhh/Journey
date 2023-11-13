package com.example.journey.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val content: String,
    val creationDate: LocalDateTime,
    val taskId: Long? = null, // Foreign key to Task
    val eventId: Long? = null,  // Foreign key to Event
    val categoryId: Long? = null// Foreign key to Category
)

