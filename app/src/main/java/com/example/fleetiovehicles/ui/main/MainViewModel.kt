package com.example.fleetiovehicles.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.fleetiocore.services.VehicleService

class MainViewModel(private val vehicleService : VehicleService) : ViewModel() {

    val isRefreshing = MutableLiveData(false)

    fun getVehicles() = vehicleService.getVehicles().cachedIn(viewModelScope)
}