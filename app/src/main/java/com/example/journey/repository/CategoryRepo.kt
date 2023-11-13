package com.example.journey.repository

import com.example.journey.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepo
{
    fun getCategories(): Flow<List<Category>>
    fun getCategory(categoryId: Long): Flow<Category>
    suspend fun addCategory(category: Category)
    suspend fun updateCategory(category: Category)
    suspend fun deleteCategory(categoryId: Long)
}