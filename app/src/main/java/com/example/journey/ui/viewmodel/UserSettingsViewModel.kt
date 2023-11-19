package com.example.journey.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.journey.model.UserSettings
import com.example.journey.repository.UserSettingsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserSettingsViewModel @Inject constructor(private val userSettingsRepo: UserSettingsRepo) : ViewModel() {

    // StateFlow for user settings
    private val _userSettings = MutableStateFlow<UserSettings?>(null)
    val userSettings: StateFlow<UserSettings?> = _userSettings.asStateFlow()

    init {
        loadUserSettings()
    }

    private fun loadUserSettings() {
        viewModelScope.launch {
            userSettingsRepo.getUserSettings().collect { settings ->
                _userSettings.value = settings
            }
        }
    }

    fun updateUserSettings(settings: UserSettings) {
        viewModelScope.launch {
            userSettingsRepo.updateUserSettings(settings)
            // Optionally reload settings if needed
            loadUserSettings()
        }
    }

    // Additional methods as needed
}