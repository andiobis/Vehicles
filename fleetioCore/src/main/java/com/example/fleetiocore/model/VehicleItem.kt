package com.example.fleetiocore.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class VehicleItem(
    @SerializedName("account_id")
    var accountId: Int,
    @SerializedName("ai_enabled")
    var aiEnabled: Boolean,
    @SerializedName("archived_at")
    var archivedAt: Any?,
    @SerializedName("assetable_type")
    var assetableType: String,
    @SerializedName("color")
    var color: String?,
    @SerializedName("comments_count")
    var commentsCount: Int,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("current_location_entry")
    var currentLocationEntry: CurrentLocationEntry?,
    @SerializedName("current_location_entry_id")
    var currentLocationEntryId: Int?,
    @SerializedName("current_meter_date")
    var currentMeterDate: String?,
    @SerializedName("current_meter_value")
    var currentMeterValue: Double,
    @SerializedName("custom_fields")
    var customFields: CustomFields,
    @SerializedName("default_image_url")
    var defaultImageUrl: String?,
    @SerializedName("default_image_url_large")
    var defaultImageUrlLarge: String?,
    @SerializedName("default_image_url_medium")
    var defaultImageUrlMedium: String?,
    @SerializedName("default_image_url_small")
    var defaultImageUrlSmall: String?,
    @SerializedName("documents_count")
    var documentsCount: Int,
    @SerializedName("driver")
    var driver: Driver?,
    @SerializedName("estimated_replacement_mileage")
    var estimatedReplacementMileage: Int?,
    @SerializedName("estimated_resale_price")
    var estimatedResalePrice: EstimatedResalePrice?,
    @SerializedName("estimated_service_months")
    var estimatedServiceMonths: Int?,
    @SerializedName("external_ids")
    var externalIds: ExternalIds,
    @SerializedName("fuel_entries_count")
    var fuelEntriesCount: Int,
    @SerializedName("fuel_type_id")
    var fuelTypeId: Int?,
    @SerializedName("fuel_type_name")
    var fuelTypeName: String?,
    @SerializedName("fuel_volume_units")
    var fuelVolumeUnits: FuelVolumeUnits,
    @SerializedName("group_ancestry")
    var groupAncestry: String?,
    @SerializedName("group_id")
    var groupId: Int?,
    @SerializedName("group_name")
    var groupName: String?,
    @SerializedName("id")
    var id: Int,
    @SerializedName("images_count")
    var imagesCount: Int,
    @SerializedName("in_service_date")
    var inServiceDate: String?,
    @SerializedName("in_service_meter")
    var inServiceMeter: Int?,
    @SerializedName("inspection_schedules_count")
    var inspectionSchedulesCount: Int,
    @SerializedName("is_sample")
    var isSample: Boolean,
    @SerializedName("issues_count")
    var issuesCount: Int,
    @SerializedName("license_plate")
    var licensePlate: String?,
    @SerializedName("loan_account_number")
    var loanAccountNumber: String?,
    @SerializedName("loan_amount")
    var loanAmount: Double?,
    @SerializedName("loan_ended_at")
    var loanEndedAt: String?,
    @SerializedName("loan_interest_rate")
    var loanInterestRate: Double?,
    @SerializedName("loan_notes")
    var loanNotes: String?,
    @SerializedName("loan_payment")
    var loanPayment: Double?,
    @SerializedName("loan_started_at")
    var loanStartedAt: String?,
    @SerializedName("loan_vendor_id")
    var loanVendorId: Int?,
    @SerializedName("loan_vendor_name")
    var loanVendorName: String?,
    @SerializedName("make")
    var make: String?,
    @SerializedName("meter_name")
    var meterName: String,
    @SerializedName("meter_unit")
    var meterUnit: MeterUnit,
    @SerializedName("model")
    var model: String?,
    @SerializedName("name")
    var name: String,
    @SerializedName("out_of_service_date")
    var outOfServiceDate: String?,
    @SerializedName("out_of_service_meter")
    var outOfServiceMeter: Int?,
    @SerializedName("ownership")
    var ownership: VehicleOwnershipStatus,
    @SerializedName("primary_meter_usage_per_day")
    var primaryMeterUsagePerDay: String?,
    @SerializedName("registration_expiration_month")
    var registrationExpirationMonth: Int,
    @SerializedName("registration_state")
    var registrationState: String?,
    @SerializedName("residual_value")
    var residualValue: Int?,
    @SerializedName("secondary_meter")
    var secondaryMeter: Boolean,
    @SerializedName("secondary_meter_date")
    var secondaryMeterDate: String?,
    @SerializedName("secondary_meter_name")
    var secondaryMeterName: String,
    @SerializedName("secondary_meter_unit")
    var secondaryMeterUnit: MeterUnit?,
    @SerializedName("secondary_meter_usage_per_day")
    var secondaryMeterUsagePerDay: String?,
    @SerializedName("secondary_meter_value")
    var secondaryMeterValue: Double,
    @SerializedName("service_entries_count")
    var serviceEntriesCount: Int,
    @SerializedName("service_reminders_count")
    var serviceRemindersCount: Int,
    @SerializedName("specs")
    var specs: Specs,
    @SerializedName("system_of_measurement")
    var systemOfMeasurement: MeasurementSystem,
    @SerializedName("trim")
    var trim: String?,
    @SerializedName("type_name")
    var typeName: String,
    @SerializedName("updated_at")
    var updatedAt: String,
    @SerializedName("vehicle_renewal_reminders_count")
    var vehicleRenewalRemindersCount: Int,
    @SerializedName("vehicle_status_color")
    var vehicleStatusColor: String?,
    @SerializedName("vehicle_status_id")
    var vehicleStatusId: Int,
    @SerializedName("vehicle_status_name")
    var vehicleStatusName: String,
    @SerializedName("vehicle_type_id")
    var vehicleTypeId: Int,
    @SerializedName("vehicle_type_name")
    var vehicleTypeName: String,
    @SerializedName("vin")
    var vin: String?,
    @SerializedName("work_orders_count")
    var workOrdersCount: Int,
    @SerializedName("year")
    var year: Int?
)

fun VehicleItem.getLocation(): Pair<Double, Double>? {
    val longitude = currentLocationEntry?.geolocation?.longitude ?: return null
    val latitude = currentLocationEntry?.geolocation?.latitude ?: return null
    return Pair(latitude, longitude)
}

enum class FuelVolumeUnits {
    us_gallons, uk_gallons, liters
}

enum class MeterUnit {
    km, hr, mi
}

enum class VehicleOwnershipStatus {
    Owned, owned, leased, Leased, rented, Rented, customer, Customer
}

enum class MeasurementSystem {
    imperial, metric
}