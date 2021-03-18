package com.example.toshiroapp.model.weather


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Long,
    @SerializedName("alerts")
    val alerts: Alerts,
    @SerializedName("current")
    val current: Current,
    @SerializedName("forecast")
    val forecast: Forecast,
    @SerializedName("location")
    val location: Location,
    var dateAdded : Date = Date()
)