package com.example.journey.repository

import com.example.journey.model.Event
import kotlinx.coroutines.flow.Flow

interface EventRepo {
    fun getEvents(): Flow<List<Event>>
    fun getEvent(eventId: Long): Flow<Event>
    suspend fun addEvent(event: Event)
    suspend fun updateEvent(event: Event)
    suspend fun deleteEvent(eventId: Long)
}
