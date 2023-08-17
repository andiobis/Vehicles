package com.example.fleetiovehicles.ui.detailsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fleetiocore.model.FleetioError
import com.example.fleetiocore.model.VehicleItem
import com.example.fleetiocore.util.EitherResult
import com.example.fleetiocore.webService.WebService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(private val webService: WebService,private val vehicleId : Int) : ViewModel() {

    private val _vehicle : MutableStateFlow<EitherResult<VehicleItem, FleetioError>?> = MutableStateFlow(null)

    val vehicleState : StateFlow<EitherResult<VehicleItem, FleetioError>?>
    get() = _vehicle

    fun loadVehicleDetails() {
        viewModelScope.launch {
         _vehicle.emit(webService.getVehicle(vehicleId))
        }
    }

    init {
        loadVehicleDetails()
    }
}