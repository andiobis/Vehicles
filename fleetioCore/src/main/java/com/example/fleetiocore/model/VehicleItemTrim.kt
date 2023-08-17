package com.example.fleetiocore.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class VehicleItemTrim(
    @SerializedName("account_id")
    var accountId: Int,
    @SerializedName("color")
    var color: String?,
    @SerializedName("comments_count")
    var commentsCount: Int,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("current_location_entry")
    var currentLocationEntry: CurrentLocationEntry?,
    var defaultImageUrl: String?,
    @SerializedName("default_image_url_large")
    var defaultImageUrlLarge: String?,
    @SerializedName("default_image_url_medium")
    var defaultImageUrlMedium: String?,
    @SerializedName("default_image_url_small")
    var defaultImageUrlSmall: String?,
    @SerializedName("id")
    var id: Int,
    @SerializedName("license_plate")
    var licensePlate: String?,
    @SerializedName("make")
    var make: String?,
    @SerializedName("model")
    var model: String?,
    @SerializedName("name")
    var name: String,
    @SerializedName("vin")
    var vin: String?,
    @SerializedName("year")
    var year: Int?
)