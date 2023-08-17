package com.example.fleetiocore.remoteAPI

import com.example.fleetiocore.model.VehicleItem
import com.example.fleetiocore.model.VehicleItemTrim
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path
import retrofit2.http.Query

interface VehiclesAPI {

    @GET("vehicles")
    suspend fun getVehicles(@HeaderMap headers: Map<String, String>, @Query("page") page: Int) : Response<List<VehicleItemTrim>>

    @GET("vehicles/{id}")
    suspend fun getVehicle(@HeaderMap headers: Map<String, String>, @Path("id") id : Int) : Response<VehicleItem>
}