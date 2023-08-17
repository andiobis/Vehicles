package com.example.fleetiocore.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class AddressComponents(
    @SerializedName("city")
    var city: String?,
    @SerializedName("country")
    var country: String?,
    @SerializedName("country_short")
    var countryShort: String?,
    @SerializedName("postal_code")
    var postalCode: String?,
    @SerializedName("region")
    var region: String?,
    @SerializedName("region_short")
    var regionShort: String?,
    @SerializedName("street")
    var street: String?,
    @SerializedName("street_number")
    var streetNumber: String?
)