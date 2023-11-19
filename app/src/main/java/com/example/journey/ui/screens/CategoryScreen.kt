package com.example.journey.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.journey.model.Category
import com.example.journey.model.Event
import com.example.journey.ui.viewmodel.CategoryViewModel
import com.example.journey.ui.viewmodel.EventsViewModel
import com.example.journey.ui.viewmodel.NotesViewModel

@Composable
fun CategoryScreen() {
    val viewModel: CategoryViewModel = viewModel()
    val categories = viewModel.categories.collectAsState().value

    // UI to display events
    LazyColumn {
        items(categories) { category ->
            CategoryItem(category, onCategoryClicked = { /* Handle event click */ })
        }
    }
}

@Composable
fun CategoryItem(category: Category, onCategoryClicked: (Category) -> Unit) {
    // Layout for each event item
    Text(text = category.name, modifier = Modifier.clickable { onCategoryClicked(category) })
    // Add more details as needed
}
