package com.example.journey.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val color: String // You can store color as a String (e.g., hex code)
    // Optional: Add an icon field if you want to represent categories with icons
)