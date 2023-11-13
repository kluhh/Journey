package com.example.journey.model

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDateTime

class Converters {
    @TypeConverter
    fun fromLocalDate(date: LocalDate): String = date.toString()

    @TypeConverter
    fun toLocalDate(dateString: String): LocalDate = LocalDate.parse(dateString)

    @TypeConverter
    fun fromLocalDateTime(date: LocalDateTime): String = date.toString()

    @TypeConverter
    fun toLocalDateTime(dateString: String): LocalDateTime = LocalDateTime.parse(dateString)
}