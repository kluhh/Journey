package com.example.journey.di

import android.content.Context
import androidx.room.Room
import com.example.journey.data.AppDatabase
import com.example.journey.data.CategoryDao
import com.example.journey.data.EventDao
import com.example.journey.data.NoteDao
import com.example.journey.data.TaskDao
import com.example.journey.data.UserSettingsDao
import com.example.journey.repository.CategoryRepo
import com.example.journey.repository.CategoryRepoImpl
import com.example.journey.repository.EventRepo
import com.example.journey.repository.EventRepoImpl
import com.example.journey.repository.NoteRepo
import com.example.journey.repository.NoteRepoImpl
import com.example.journey.repository.TaskRepoImpl
import com.example.journey.repository.TaskRepo
import com.example.journey.repository.UserSettingsRepo
import com.example.journey.repository.UserSettingsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule
{
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase
    {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ) // Migration strategies can be defined here
            .build()
    }

    @Provides
    fun provideCategoryDao(database: AppDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    fun provideEventDao(database: AppDatabase): EventDao {
        return database.eventDao()
    }

    @Provides
    fun provideTaskDao(database: AppDatabase): TaskDao {
        return database.taskDao()
    }

    @Provides
    fun provideNoteDao(database: AppDatabase): NoteDao {
        return database.noteDao()
    }

    @Provides
    fun provideUserSettingsDao(database: AppDatabase): UserSettingsDao {
        return database.userSettingsDao()
    }
    @Provides
    @Singleton
    fun provideEventRepository(eventDao: EventDao): EventRepo
    {
        return EventRepoImpl(eventDao)
    }

    @Provides
    @Singleton
    fun provideTaskRepository(taskDao: TaskDao): TaskRepo
    {
        return TaskRepoImpl(taskDao)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao): NoteRepo
    {
        return NoteRepoImpl(noteDao)
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(categoryDao: CategoryDao): CategoryRepo
    {
        return CategoryRepoImpl(categoryDao)
    }

    @Provides
    @Singleton
    fun provideUserSettingsRepository(userSettingsDao: UserSettingsDao): UserSettingsRepo
    {
        return UserSettingsRepoImpl(userSettingsDao)
    }


}
