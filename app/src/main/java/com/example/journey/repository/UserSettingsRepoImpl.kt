package com.example.journey.repository

import com.example.journey.data.UserSettingsDao
import com.example.journey.model.UserSettings
import kotlinx.coroutines.flow.Flow

class UserSettingsRepoImpl(private val userSettingsDao: UserSettingsDao): UserSettingsRepo
{
    override fun getUserSettings(): Flow<UserSettings>
    {
        return userSettingsDao.getUserSettingsFlow()
    }

    override suspend fun updateUserSettings(userSettings: UserSettings) {
        userSettingsDao.updateUserSettings(userSettings)
    }
}