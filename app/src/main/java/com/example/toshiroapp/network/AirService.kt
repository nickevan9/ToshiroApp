package com.example.toshiroapp.network

import com.example.toshiroapp.model.air.AirEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AirService {
    @GET("query.php")
    fun fetchAirIndex(@Query("lat") lat: Double?, @Query("lng") lon: Double?): Call<AirEntity>
}