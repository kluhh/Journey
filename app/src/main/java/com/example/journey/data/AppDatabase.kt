package com.example.journey.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.journey.model.Category
import com.example.journey.model.Converters
import com.example.journey.model.Event
import com.example.journey.model.Note
import com.example.journey.model.Task
import com.example.journey.model.UserSettings

@Database(
    entities = [Task::class, Event::class, Note::class, Category::class, UserSettings::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class) // This line is crucial
abstract class AppDatabase : RoomDatabase()
{
    abstract fun categoryDao(): CategoryDao
    abstract fun eventDao(): EventDao
    abstract fun taskDao(): TaskDao
    abstract fun noteDao(): NoteDao
    abstract fun userSettingsDao(): UserSettingsDao

}