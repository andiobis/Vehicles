package com.example.fleetiovehicles.ui.theme


import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(),
    h2 = TextStyle(),
    h3 = TextStyle(),
    h4 = TextStyle(),
    h5 = TextStyle(),
    h6 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    subtitle2 = TextStyle(),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    overline = TextStyle()
)