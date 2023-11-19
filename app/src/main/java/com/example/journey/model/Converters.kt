package com.example.journey.model

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDateTime

class Converters {
    @TypeConverter
    fun fromLocalDate(date: LocalDate?): String? = date?.toString()

    @TypeConverter
    fun toLocalDate(dateString: String?): LocalDate? {
        return if (dateString != null && dateString != "null") {
            LocalDate.parse(dateString)
        } else {
            null
        }
    }
    @TypeConverter
    fun fromLocalDateTime(date: LocalDateTime?): String? = date?.toString()

    @TypeConverter
    fun toLocalDateTime(dateString: String?): LocalDateTime? = dateString?.let { LocalDateTime.parse(it) }
}
