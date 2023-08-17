package com.example.fleetiocore.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CurrentLocationEntry(
    @SerializedName("address")
    var address: String?,
    @SerializedName("address_components")
    var addressComponents: AddressComponents?,
    @SerializedName("contact_id")
    var contactId: Any?,
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("date")
    var date: String?,
    @SerializedName("geolocation")
    var geolocation: Geolocation?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("is_current")
    var isCurrent: Boolean?,
    @SerializedName("item_id")
    var itemId: Int?,
    @SerializedName("item_type")
    var itemType: String?,
    @SerializedName("locatable_id")
    var locatableId: Int?,
    @SerializedName("locatable_type")
    var locatableType: String?,
    @SerializedName("location")
    var location: String?,
    @SerializedName("updated_at")
    var updatedAt: String?,
    @SerializedName("vehicle_id")
    var vehicleId: Int?
)

