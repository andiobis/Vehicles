package com.example.fleetiovehicles.ui.detailsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.fleetiocore.model.VehicleItem
import com.example.fleetiocore.model.getLocation
import com.example.fleetiocore.model.isDriverAvail
import com.example.fleetiocore.util.EitherResult
import com.example.fleetiovehicles.R
import com.example.fleetiovehicles.ui.components.DriverInfo
import com.example.fleetiovehicles.ui.components.ErrorDetails
import com.example.fleetiovehicles.ui.theme.AppTheme
import com.example.fleetiovehicles.ui.theme.Gray
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailsFragment : Fragment() {

    private var id: Int? = null
    private val viewModel: DetailsViewModel by viewModel { parametersOf(id) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        id = arguments?.getInt("id", 0)

        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    DetailsScreen(modifier = Modifier, viewModel = viewModel)
                }
            }
        }
    }

    @Composable
    fun DetailsScreen(modifier: Modifier, viewModel: DetailsViewModel) {

        val state = viewModel.vehicleState.collectAsState()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = getString(R.string.vehicle_details),
                            color = MaterialTheme.colors.onBackground
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            findNavController().popBackStack()
                        }) {
                            Icon(Icons.Filled.ArrowBack, "")
                        }
                    },
                    backgroundColor = Color.White,
                    contentColor = MaterialTheme.colors.primary,
                    elevation = 5.dp
                )
            },
            content = {
                Surface(
                    Modifier
                        .fillMaxWidth()
                        .padding(it), color = Color(0xFFF5F5F5)
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                    ) {
                        when (val vehicleState = state.value) {
                            is EitherResult.Failure -> {
                                ErrorDetails(
                                    modifier,
                                    getString(R.string.error),
                                    getString(R.string.retry)
                                ) {
                                    viewModel.loadVehicleDetails()
                                }
                            }
                            is EitherResult.Success -> {
                                SuccessDetails(modifier = modifier, vehicleState.value)
                            }
                            else -> {}
                        }
                    }
                }
            },
            bottomBar = {
            }
        )


    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    private fun SuccessDetails(modifier: Modifier, vehicleItem: VehicleItem) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
        ) {
            GlideImage(
                model = vehicleItem.defaultImageUrlLarge ?: R.drawable.vehicle_place_holder,
                contentDescription = "",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )

            Text(
                text = vehicleItem.name ?: "Uknown Name",
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp)
            )

            Row(
                Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp)
            ) {

                Text(
                    text = getString(R.string.vehicle_details),
                    color = Gray,
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                val year = (vehicleItem.year?.toString() ?: "").trim()
                val make = (vehicleItem.make ?: "").trim()
                val model = (vehicleItem.model ?: "").trim()

                Text(
                    text = "$year $make $model".trim(),
                    color = Gray,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .padding(start = 2.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )


            }

            Row(
                Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp)
            ) {

                Text(
                    text = getString(R.string.vin),
                    color = Gray,
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = vehicleItem.vin ?: "Unknown".trim(),
                    color = Gray,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .padding(start = 2.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )


            }

            Card(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 16.dp), shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Row {


                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = getString(
                            R.string.licence_plate,
                            vehicleItem.licensePlate ?: "Unknown"
                        ),
                        color = MaterialTheme.colors.onSecondary,
                        style = MaterialTheme.typography.subtitle1,
                    )
                }
            }
        }

        MeterInfo(
            modifier = Modifier.padding(bottom = 8.dp),
            details = vehicleItem
        )

        vehicleItem.driver?.let {
            if (it.isDriverAvail()) {
                DriverInfo(
                    modifier = Modifier.padding(bottom = 8.dp),
                    driverInfo = it
                )
            }
        }

        vehicleItem.fuelEntriesCount.let {
            FuelInfo(
                modifier = Modifier.padding(bottom = 8.dp),
                details = vehicleItem
            )
        }

        vehicleItem.getLocation()?.let {

            val carsLocation = LatLng(it.first, it.second)

            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(carsLocation, 10f)
            }

            GoogleMap(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp),
                cameraPositionState = cameraPositionState
            ) {
                Marker(
                    state = MarkerState(position = carsLocation),
                    title = vehicleItem.name,
                    snippet = getString(R.string.vehicle_location)
                )
            }

        }

    }

    @Composable
    private fun MeterInfo(modifier: Modifier, details: VehicleItem) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .background(MaterialTheme.colors.background)
        ) {
            Text(
                text = "Meters",
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )

            Text(
                text = "Current meters: ${details.currentMeterValue} ${details.meterUnit}",
                color = Gray,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = "Secondary meter: ${details.secondaryMeterValue} ${details.secondaryMeterUnit}",
                color = Gray,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
            )
        }
    }

    @Composable
    private fun FuelInfo(modifier: Modifier, details: VehicleItem) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
        ) {
            Text(
                text = "Fuel info",
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )

            Text(
                text = "Current meters: ${details.fuelEntriesCount} ${details.fuelVolumeUnits}",
                color = Gray,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = "Fuel type: ${details.fuelTypeName}",
                color = Gray,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
            )
        }
    }

}