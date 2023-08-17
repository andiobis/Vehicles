package com.example.fleetiovehicles.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ErrorDetails(modifier: Modifier, error: String, retry: String, onRetry: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = error,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h6,
        )

        Button(
            modifier = modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .fillMaxWidth()
                .height(44.dp),
            onClick = {
                onRetry.invoke()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary
            ),
            enabled = true
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = retry,
                    style = MaterialTheme.typography.button,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}