package com.example.journey.repository

import com.example.journey.data.CategoryDao
import com.example.journey.model.Category
import kotlinx.coroutines.flow.Flow

class CategoryRepoImpl(private val categoryDao: CategoryDao) : CategoryRepo
{
    override fun getCategories(): Flow<List<Category>>
    {
        return categoryDao.getCategoriesFlow()
    }

    override fun getCategory(categoryId: Long): Flow<Category>
    {
        return categoryDao.getCategoryByIdFlow(categoryId)
    }

    override suspend fun addCategory(category: Category)
    {
        return categoryDao.insertCategory(category)
    }

    override suspend fun updateCategory(category: Category)
    {
        return categoryDao.updateCategory(category)
    }

    override suspend fun deleteCategory(categoryId: Long)
    {
        categoryDao.deleteCategoryById(categoryId)
    }

}