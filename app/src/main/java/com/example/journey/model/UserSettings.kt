package com.example.journey.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_settings")
data class UserSettings(
    @PrimaryKey val id: Long = 0,
    val darkModeEnabled: Boolean,
    val notificationsEnabled: Boolean,
    // Add other settings as needed
)