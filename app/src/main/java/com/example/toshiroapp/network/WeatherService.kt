package com.example.toshiroapp.network

import com.example.toshiroapp.model.weather.WeatherEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("current.php")
    fun fetchWeatherData(
        @Query("lat") lat: Double?,
        @Query("lon") lon: Double?
    ): Call<WeatherEntity>
}