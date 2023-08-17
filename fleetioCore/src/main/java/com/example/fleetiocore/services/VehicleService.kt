package com.example.fleetiocore.services

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.fleetiocore.model.FleetioError
import com.example.fleetiocore.model.VehicleItem
import com.example.fleetiocore.model.VehicleItemTrim
import com.example.fleetiocore.util.EitherResult
import com.example.fleetiocore.webService.VehiclePagingSource
import com.example.fleetiocore.webService.WebService
import kotlinx.coroutines.flow.Flow


interface VehicleService {

    fun getVehicles(): Flow<PagingData<VehicleItemTrim>>
    suspend fun getVehicle(id: Int): EitherResult<VehicleItem, FleetioError>
}

class VehicleServiceImpl(private val webService: WebService) : VehicleService {

   override fun getVehicles() = Pager(
        config = PagingConfig(
            pageSize = 30,
        ),
        pagingSourceFactory = {
            VehiclePagingSource(webService)
        }
    ).flow

    override suspend fun getVehicle(id : Int) = webService.getVehicle(id)

}