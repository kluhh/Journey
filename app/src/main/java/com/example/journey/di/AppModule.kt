package com.example.journey.di

import com.example.journey.data.CategoryDao
import com.example.journey.data.EventDao
import com.example.journey.data.NoteDao
import com.example.journey.data.TaskDao
import com.example.journey.repository.CategoryRepo
import com.example.journey.repository.CategoryRepoImpl
import com.example.journey.repository.EventRepo
import com.example.journey.repository.EventRepoImpl
import com.example.journey.repository.NoteRepo
import com.example.journey.repository.NoteRepoImpl
import com.example.journey.repository.TaskRepoImpl
import com.example.journey.repository.TaskRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
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



}
