package com.example.hw3_compose.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.hw3_compose.ui.theme.ViewModule.LocationViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LocationDetailScreen(locationId: Int) {
    val viewModel: LocationViewModel = koinViewModel()

    LaunchedEffect(locationId) {
        viewModel.loadLocationDetails(locationId)
    }

    val location = viewModel.locationDetails.collectAsState().value

    if (location == null) {
        Text(text = "Загрузка...")
    } else {
        Column {
            Text(text = "Name: ${location.name}")
            Text(text = "Type: ${location.type}")
            Text(text = "Dimension: ${location.dimension}")
        }
    }
}
