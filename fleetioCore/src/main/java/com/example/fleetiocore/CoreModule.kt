package com.example.fleetiocore

import androidx.paging.PagingSource
import com.example.fleetiocore.model.VehicleItemTrim
import com.example.fleetiocore.remoteAPI.RetrofitFactoryBase
import com.example.fleetiocore.services.VehicleService
import com.example.fleetiocore.services.VehicleServiceImpl
import com.example.fleetiocore.webService.VehiclePagingSource
import com.example.fleetiocore.webService.WebService
import com.example.fleetiocore.webService.WebServiceImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module

val coreModule = module {

    single { OkHttpClient() as OkHttpClient }
    single { RetrofitFactoryBase(get()) as RetrofitFactoryBase}
    single { WebServiceImpl(get(), get()) as WebService }
    factory { VehiclePagingSource(get()) as PagingSource<Int, VehicleItemTrim>}
    single { VehicleServiceImpl(get()) as VehicleService }

}