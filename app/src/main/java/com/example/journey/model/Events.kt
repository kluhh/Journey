package com.example.journey.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "events")
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String?,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val location: String?,
    val isAllDay: Boolean?,
    val categoryId: Long? = null// Foreign key to Category

)