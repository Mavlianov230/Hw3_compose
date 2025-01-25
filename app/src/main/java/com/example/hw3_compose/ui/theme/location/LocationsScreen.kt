package com.example.hw3_compose.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.hw3_compose.ui.theme.ViewModule.LocationViewModel
import com.example.hw3_compose.ui.theme.location.LocationResponse
import org.koin.androidx.compose.koinViewModel

@Composable
fun LocationsScreen(navController: NavController) {
    val viewModel: LocationViewModel = koinViewModel()
    val locations = viewModel.locations.collectAsState().value

    LazyColumn {
        items(locations) { location ->
            Text(
                text = location.name,
                modifier = Modifier.clickable {
                    navController.navigate("location_detail/${location.id}")
                }
            )
        }
    }
}