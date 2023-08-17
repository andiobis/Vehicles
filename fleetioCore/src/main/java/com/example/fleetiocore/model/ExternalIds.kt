package com.example.fleetiocore.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ExternalIds(
    @SerializedName("adf_truncate_table_users")
    var adfTruncateTableUsers: Any?,
    @SerializedName("clearpathgps")
    var clearpathgps: String?,
    @SerializedName("external_fuel_id")
    var externalFuelId: String?,
    @SerializedName("fuel_card_id")
    var fuelCardId: Any?,
    @SerializedName("fuel_id")
    var fuelId: String?,
    @SerializedName("task_code")
    var taskCode: String?,
    @SerializedName("traxxis_id")
    var traxxisId: String?
)