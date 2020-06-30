package com.example.geomob
import com.google.gson.Gson

import androidx.room.TypeConverter
class Converters {

    @TypeConverter
    fun listToJson(value: List<Int>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Int>::class.java).toList()
}