package com.example.toshiroapp.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.toshiroapp.model.typeconvert.DateConvert
import com.example.toshiroapp.model.typeconvert.FcdTypeConvert
import com.example.toshiroapp.model.typeconvert.FchTypeConvert

@Database(entities = [WeatherModel::class], version = 1, exportSchema = true)
@TypeConverters(value = [DateConvert::class,FcdTypeConvert::class,FchTypeConvert::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
}
