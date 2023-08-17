package com.example.fleetiocore.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CustomFields(
    @SerializedName("checkbox_filter_test")
    var checkboxFilterTest: String?,
    @SerializedName("extra_rextra_read_all_about_it_this_is_a_super_long_field_name_my_guyyy")
    var extraRextraReadAllAboutItThisIsASuperLongFieldNameMyGuyyy: String,
    @SerializedName("manufacturer_model")
    var manufacturerModel: String?,
    @SerializedName("name123")
    var name123: String,
    @SerializedName("rear_camera_enabled")
    var rearCameraEnabled: String,
    @SerializedName("registration_expiration")
    var registrationExpiration: String,
    @SerializedName("restrict")
    var restrict: String?,
    @SerializedName("telematics_subscription")
    var telematicsSubscription: String?,
    @SerializedName("test")
    var test: String,
    @SerializedName("test_roles_on_restricted_custom_fields")
    var testRolesOnRestrictedCustomFields: String,
    @SerializedName("toll_pass_number")
    var tollPassNumber: String,
    @SerializedName("vehicle")
    var vehicle: String,
    @SerializedName("vehicle_cleanliness")
    var vehicleCleanliness: String?,
    @SerializedName("warranty_expiration")
    var warrantyExpiration: String?,
    @SerializedName("warranty_type")
    var warrantyType: String?
)