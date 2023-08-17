package com.example.fleetiocore.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class EstimatedResalePrice(
    @SerializedName("cents")
    var cents: Int,
    @SerializedName("currency_iso")
    var currencyIso: String
)