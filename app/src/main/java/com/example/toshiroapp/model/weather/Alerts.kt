package com.example.toshiroapp.model.weather


import com.google.gson.annotations.SerializedName

data class Alerts(
    @SerializedName("alert")
    val alert: List<Any>
)