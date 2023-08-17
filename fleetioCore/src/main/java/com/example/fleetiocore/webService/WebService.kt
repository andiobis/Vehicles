package com.example.fleetiocore.webService

import android.content.Context
import com.example.fleetiocore.R
import com.example.fleetiocore.model.FleetioError
import com.example.fleetiocore.model.VehicleItem
import com.example.fleetiocore.model.VehicleItemTrim
import com.example.fleetiocore.remoteAPI.APIConstants
import com.example.fleetiocore.remoteAPI.RetrofitFactoryBase
import com.example.fleetiocore.remoteAPI.VehiclesAPI
import com.example.fleetiocore.util.EitherResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface WebService {
    suspend fun getVehicles(page: Int): EitherResult<List<VehicleItemTrim>, FleetioError>
    suspend fun getVehicle(id: Int): EitherResult<VehicleItem, FleetioError>
}

internal class WebServiceImpl(private val retrofitBase : RetrofitFactoryBase, context : Context) : WebService {

    companion object {
        const val AUTH = "Authorization"
        const val TOKEN = "Token token="
        const val ACCOUNT_TOKEN = "Account-Token"
    }

    val headerMap = hashMapOf(AUTH to "$TOKEN${context.getString(R.string.api_key)}", ACCOUNT_TOKEN to context.getString(R.string.user_id))

    private val vehicleApi : VehiclesAPI by lazy {
        retrofitBase.provideRetrofit(APIConstants.BASE_URL, VehiclesAPI::class.java)
    }

   override suspend fun getVehicles(page : Int) : EitherResult<List<VehicleItemTrim>, FleetioError> = withContext(Dispatchers.IO) {
      return@withContext try {
          val request = vehicleApi.getVehicles(headerMap, page)
          EitherResult.success(request.body()!!)
       }catch (e : Exception) {
           EitherResult.error(FleetioError.GenericError(e.localizedMessage, e))
       }
   }

    override suspend fun getVehicle(id : Int) : EitherResult<VehicleItem, FleetioError> = withContext(Dispatchers.IO) {
        return@withContext try {
            val request = vehicleApi.getVehicle(headerMap, id)
            EitherResult.success(request.body()!!)
        }catch (e : Exception) {
            EitherResult.error(FleetioError.GenericError(e.localizedMessage, e))
        }
    }
}