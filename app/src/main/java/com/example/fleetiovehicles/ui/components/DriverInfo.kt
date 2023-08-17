package com.example.fleetiovehicles.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.example.fleetiocore.model.Driver
import com.example.fleetiovehicles.R


@ExperimentalGlideComposeApi
@Composable
fun DriverInfo(
    modifier: Modifier,
    driverInfo: Driver
) {

    if (driverInfo.fullName.isNullOrEmpty()) return

    Card(modifier = modifier) {
        Column(
            Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(
                text = "Driver",
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                Modifier
                    .fillMaxWidth(),
                verticalAlignment = CenterVertically
            ) {

                GlideImage(
                    model = driverInfo.defaultImageUrl ?: R.drawable.vehicle_place_holder,
                    contentDescription = "Driver image",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(75.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )

                Column(
                    Modifier
                        .align(alignment = CenterVertically)
                ) {

                    Text(
                        text = driverInfo.fullName ?: "Unknown Name",
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .padding(start = 8.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

        }

    }

}