package com.example.journey.repository

import com.example.journey.data.EventDao
import com.example.journey.model.Event
import kotlinx.coroutines.flow.Flow

class EventRepoImpl(private val eventDao: EventDao) : EventRepo {

    override fun getEvents(): Flow<List<Event>>
    {
        return eventDao.getEventsFlow()
    }

    override fun getEvent(eventId: Long): Flow<Event> {
        return eventDao.getEventByIdFlow(eventId)
    }

    override suspend fun addEvent(event: Event) {
        eventDao.insertEvent(event)
    }

    override suspend fun updateEvent(event: Event) {
        eventDao.updateEvent(event)
    }

    override suspend fun deleteEvent(eventId: Long) {
        eventDao.deleteEventById(eventId)
    }
}
