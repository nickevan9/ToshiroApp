package com.example.toshiroapp.model.weather


import com.google.gson.annotations.SerializedName

data class ConditionX(
    @SerializedName("code")
    val code: Int,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("text")
    val text: String
)