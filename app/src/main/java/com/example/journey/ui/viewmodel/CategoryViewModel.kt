package com.example.journey.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.journey.model.Category
import com.example.journey.repository.CategoryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val categoryRepo: CategoryRepo) : ViewModel() {

    // StateFlow for the list of categories
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories.asStateFlow()

    // StateFlow for a selected category
    private val _selectedCategory = MutableStateFlow<Category?>(null)
    val selectedCategory: StateFlow<Category?> = _selectedCategory.asStateFlow()

    init {
        loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch {
            categoryRepo.getCategories().collect { listOfCategories ->
                _categories.value = listOfCategories
            }
        }
    }

    fun getCategory(categoryId: Long) {
        viewModelScope.launch {
            categoryRepo.getCategory(categoryId).collect { category ->
                _selectedCategory.value = category
            }
        }
    }

    fun addCategory(category: Category) {
        viewModelScope.launch {
            categoryRepo.addCategory(category)
            loadCategories() // Refresh the list
        }
    }

    fun updateCategory(category: Category) {
        viewModelScope.launch {
            categoryRepo.updateCategory(category)
            loadCategories() // Refresh the list
        }
    }

    fun deleteCategory(categoryId: Long) {
        viewModelScope.launch {
            categoryRepo.deleteCategory(categoryId)
            loadCategories() // Refresh the list
        }
    }

    // Additional methods as needed
}