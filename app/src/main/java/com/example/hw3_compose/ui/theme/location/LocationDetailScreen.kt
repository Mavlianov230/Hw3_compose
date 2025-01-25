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

    location?.let {
        Column {
            Text(text = "Name: ${it.name}")
            Text(text = "Type: ${it.type}")
            Text(text = "Dimension: ${it.dimension}")
        }
    } ?: Text(text = "Loading...")
}