package com.example.toshiroapp.model.weather


import com.google.gson.annotations.SerializedName

data class Forecastday(
    @SerializedName("astro")
    val astro: Astro,
    @SerializedName("date")
    val date: String,
    @SerializedName("date_epoch")
    val dateEpoch: Int,
    @SerializedName("day")
    val daily: Daily,
    @SerializedName("hour")
    val hourly: List<Hourly>
)