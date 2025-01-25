package com.example.hw3_compose.ui.theme.ViewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.ui.theme.data.repository.LocationRepository
import com.example.hw3_compose.ui.theme.location.LocationResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationViewModel(private val locationRepository: LocationRepository) : ViewModel() {

    private val _locations = MutableStateFlow<List<LocationResponse.Location>>(emptyList())
    val locations: StateFlow<List<LocationResponse.Location>> = _locations

    private val _locationDetails = MutableStateFlow<LocationResponse.Location?>(null)
    val locationDetails: StateFlow<LocationResponse.Location?> = _locationDetails

    fun loadLocations() {
        viewModelScope.launch {
            try {
                val response = locationRepository.getLocations()
                if (response.isSuccessful) {
                    _locations.value = response.body()?.results ?: emptyList()
                }
            } catch (e: Exception) {
                Log.e("ololo", "Ошибка при загрузке данных: ${e.message}", e)
            }
        }
    }

    fun loadLocationDetails(id: Int) {
        viewModelScope.launch {
            try {
                val response = locationRepository.getLocationDetails(id)
                if (response.isSuccessful) {
                    _locationDetails.value = response.body()
                }
            } catch (e: Exception) {
                Log.e("ololo", "Ошибка при загрузке данных: ${e.message}", e)
            }
        }
    }
}