
package com.example.hw3_compose.ui.theme.data.repository

import com.example.hw3_compose.ui.theme.data.api.LocationApiService

class LocationRepository(private val locationApiService: LocationApiService) {

    suspend fun getLocations() = locationApiService.getLocations()

    suspend fun getLocationDetails(id: Int) = locationApiService.getLocationDetails(id)
}