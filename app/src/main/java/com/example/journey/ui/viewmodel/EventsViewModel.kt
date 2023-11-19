package com.example.journey.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.journey.model.Event
import com.example.journey.repository.EventRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(private val eventRepo: EventRepo) : ViewModel() {

    // StateFlow for the list of events
    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events.asStateFlow()

    // StateFlow for a selected event
    private val _selectedEvent = MutableStateFlow<Event?>(null)
    val selectedEvent: StateFlow<Event?> = _selectedEvent.asStateFlow()

    init {
        loadEvents()
    }

    private fun loadEvents() {
        viewModelScope.launch {
            eventRepo.getEvents().collect { listOfEvents ->
                _events.value = listOfEvents
            }
        }
    }

    fun getEvent(eventId: Long) {
        viewModelScope.launch {
            eventRepo.getEvent(eventId).collect { event ->
                _selectedEvent.value = event
            }
        }
    }

    fun addEvent(event: Event) {
        viewModelScope.launch {
            eventRepo.addEvent(event)
            loadEvents() // Refresh the list
        }
    }

    fun updateEvent(event: Event) {
        viewModelScope.launch {
            eventRepo.updateEvent(event)
            loadEvents() // Refresh the list
        }
    }

    fun deleteEvent(eventId: Long) {
        viewModelScope.launch {
            eventRepo.deleteEvent(eventId)
            loadEvents() // Refresh the list
        }
    }

    // Additional methods as needed
}