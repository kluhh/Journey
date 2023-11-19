package com.example.journey.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.journey.model.UserSettings
import kotlinx.coroutines.flow.Flow

@Dao
interface UserSettingsDao
{
    @Query("SELECT * FROM user_settings LIMIT 1")
    fun getUserSettingsFlow(): Flow<UserSettings>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserSettings(userSettings: UserSettings)

    @Update
    suspend fun updateUserSettings(userSettings: UserSettings)
}