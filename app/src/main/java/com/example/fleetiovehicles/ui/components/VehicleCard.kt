package com.example.fleetiovehicles.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.fleetiocore.model.VehicleItemTrim
import com.example.fleetiovehicles.R
import com.example.fleetiovehicles.ui.theme.Gray


@ExperimentalGlideComposeApi
@Composable
fun VehicleCard(
    modifier: Modifier,
    vehicleInfo: VehicleItemTrim,
    onClick: ((id: Int) -> Unit)? = null
) {

    Card(
        elevation = 5.dp, modifier = modifier
            .clickable {
                onClick?.invoke(vehicleInfo.id)
            },
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
        ) {
            Row(
                Modifier
                    .fillMaxWidth(),
                verticalAlignment = CenterVertically
            ) {

                GlideImage(
                    model = vehicleInfo.defaultImageUrlSmall ?: R.drawable.vehicle_place_holder,
                    contentDescription = "Vehicle image",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(75.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Column(
                    Modifier
                        .align(alignment = CenterVertically)
                ) {

                    Text(
                        text = vehicleInfo.name,
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .padding(start = 8.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Row {

                        vehicleInfo.year?.let {
                            Text(
                                text = "$it",
                                color = Gray,
                                style = MaterialTheme.typography.subtitle1,
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        vehicleInfo.make?.let {
                            Text(
                                text = it,
                                color = Gray,
                                style = MaterialTheme.typography.subtitle1,
                                modifier = Modifier
                                    .padding(start = 4.dp),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        vehicleInfo.model?.let {
                            Text(
                                text = it,
                                color = Gray,
                                style = MaterialTheme.typography.subtitle1,
                                modifier = Modifier
                                    .padding(start = 4.dp),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    Card(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 4.dp), shape = RoundedCornerShape(8.dp),
                        backgroundColor = MaterialTheme.colors.secondary
                    ) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = "License Plate: " + (vehicleInfo.licensePlate ?: "Unknown"),
                            color = MaterialTheme.colors.onSecondary,
                            style = MaterialTheme.typography.subtitle1,
                        )
                    }

                }
            }

        }

    }

}