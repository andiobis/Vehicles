package com.example.fleetiocore.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Driver(
    @SerializedName("default_image_url")
    var defaultImageUrl: String?,
    @SerializedName("first_name")
    var firstName: String?,
    @SerializedName("full_name")
    var fullName: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("last_name")
    var lastName: String?
)

fun Driver.isDriverAvail() : Boolean{
  return  !(fullName.isNullOrEmpty() && firstName.isNullOrEmpty() && lastName.isNullOrEmpty())
}