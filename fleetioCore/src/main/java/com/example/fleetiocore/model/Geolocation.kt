package com.example.fleetiocore.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Geolocation(
    @SerializedName("latitude")
    var latitude: Double,
    @SerializedName("longitude")
    var longitude: Double
)