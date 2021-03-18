package com.example.toshiroapp.persistence

import androidx.room.*
import com.example.toshiroapp.model.weather.WeatherEntity

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherList(posters: List<WeatherEntity>)

    @Query("SELECT * FROM weatherentity WHERE id = :id_")
    fun getWeather(id_: Long): WeatherEntity

    @Query("SELECT * FROM weatherentity ORDER BY dateAdded ASC")
    fun getWeatherList(): List<WeatherEntity>

    @Delete
    fun deleteWeather(weatherModel: WeatherEntity)
}