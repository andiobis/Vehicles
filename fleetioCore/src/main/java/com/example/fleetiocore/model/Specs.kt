package com.example.fleetiocore.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Specs(
    @SerializedName("account_id")
    var accountId: Int?,
    @SerializedName("base_towing_capacity")
    var baseTowingCapacity: Int?,
    @SerializedName("bed_length")
    var bedLength: Double?,
    @SerializedName("body_subtype")
    var bodySubtype: String?,
    @SerializedName("body_type")
    var bodyType: String?,
    @SerializedName("brake_system")
    var brakeSystem: String?,
    @SerializedName("cargo_volume")
    var cargoVolume: Double?,
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("curb_weight")
    var curbWeight: Double?,
    @SerializedName("drive_type")
    var driveType: String?,
    @SerializedName("duty_type")
    var dutyType: String?,
    @SerializedName("engine_aspiration")
    var engineAspiration: String?,
    @SerializedName("engine_block_type")
    var engineBlockType: String?,
    @SerializedName("engine_bore")
    var engineBore: Double?,
    @SerializedName("engine_bore_with_units")
    var engineBoreWithUnits: String?,
    @SerializedName("engine_brand")
    var engineBrand: String?,
    @SerializedName("engine_cam_type")
    var engineCamType: String?,
    @SerializedName("engine_compression")
    var engineCompression: Double?,
    @SerializedName("engine_cylinders")
    var engineCylinders: Int?,
    @SerializedName("engine_description")
    var engineDescription: String?,
    @SerializedName("engine_displacement")
    var engineDisplacement: Double?,
    @SerializedName("engine_stroke")
    var engineStroke: Double?,
    @SerializedName("engine_valves")
    var engineValves: Int?,
    @SerializedName("epa_city")
    var epaCity: Int?,
    @SerializedName("epa_combined")
    var epaCombined: Double?,
    @SerializedName("epa_highway")
    var epaHighway: Int?,
    @SerializedName("front_tire_psi")
    var frontTirePsi: Int?,
    @SerializedName("front_tire_type")
    var frontTireType: String?,
    @SerializedName("front_track_width")
    var frontTrackWidth: Double?,
    @SerializedName("front_wheel_diameter")
    var frontWheelDiameter: String?,
    @SerializedName("fuel_induction")
    var fuelInduction: String?,
    @SerializedName("fuel_quality")
    var fuelQuality: String?,
    @SerializedName("fuel_tank_2_capacity")
    var fuelTank2Capacity: Double?,
    @SerializedName("fuel_tank_capacity")
    var fuelTankCapacity: Double?,
    @SerializedName("gross_vehicle_weight_rating")
    var grossVehicleWeightRating: Int?,
    @SerializedName("ground_clearance")
    var groundClearance: Double?,
    @SerializedName("height")
    var height: Double?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("interior_volume")
    var interiorVolume: Int?,
    @SerializedName("length")
    var length: Double?,
    @SerializedName("max_hp")
    var maxHp: Int?,
    @SerializedName("max_payload")
    var maxPayload: Int?,
    @SerializedName("max_torque")
    var maxTorque: Int?,
    @SerializedName("msrp")
    var msrp: Double?,
    @SerializedName("msrp_cents")
    var msrpCents: Int?,
    @SerializedName("oil_capacity")
    var oilCapacity: Double?,
    @SerializedName("passenger_volume")
    var passengerVolume: String?,
    @SerializedName("rear_axle_type")
    var rearAxleType: String?,
    @SerializedName("rear_tire_psi")
    var rearTirePsi: Int?,
    @SerializedName("rear_tire_type")
    var rearTireType: String?,
    @SerializedName("rear_track_width")
    var rearTrackWidth: Double?,
    @SerializedName("rear_wheel_diameter")
    var rearWheelDiameter: String?,
    @SerializedName("redline_rpm")
    var redlineRpm: String?,
    @SerializedName("transmission_brand")
    var transmissionBrand: String?,
    @SerializedName("transmission_description")
    var transmissionDescription: String?,
    @SerializedName("transmission_gears")
    var transmissionGears: Int?,
    @SerializedName("transmission_type")
    var transmissionType: String?,
    @SerializedName("updated_at")
    var updatedAt: String?,
    @SerializedName("vehicle_id")
    var vehicleId: Int?,
    @SerializedName("weight_class")
    var weightClass: String?,
    @SerializedName("wheelbase")
    var wheelbase: Double?,
    @SerializedName("wheelbase_with_units")
    var wheelbaseWithUnits: String?,
    @SerializedName("width")
    var width: Double?
)