package com.example.journey.repository

import com.example.journey.model.UserSettings
import kotlinx.coroutines.flow.Flow

interface UserSettingsRepo
{
    fun getUserSettings(): Flow<UserSettings>
    suspend fun updateUserSettings(userSettings: UserSettings)
    // Depending on your requirements, you may have additional methods
}