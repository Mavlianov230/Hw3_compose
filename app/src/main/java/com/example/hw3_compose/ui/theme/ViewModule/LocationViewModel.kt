package com.example.hw3_compose.ui.theme.ViewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.ui.theme.data.repository.LocationRepository
import com.example.hw3_compose.ui.theme.location.LocationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationViewModel(private val locationRepository: LocationRepository) : ViewModel() {

    private val _locations = MutableStateFlow<List<LocationResponse.Location>>(emptyList())
    val locations = _locations

    private val _locationDetails = MutableStateFlow<LocationResponse.Location?>(null)
    val locationDetails = _locationDetails

    fun loadLocations() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = locationRepository.getLocations()
                if (response.isSuccessful) {
                    _locations.value = response.body()?.results ?: emptyList()
                } else {
                    Log.e("ololo", "Ошибка: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("ololo", "Ошибка при загрузке данных: ${e.message}", e)
            }
        }
    }

    fun loadLocationDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = locationRepository.getLocationDetails(id)
                if (response.isSuccessful) {
                    _locationDetails.value = response.body()
                } else {
                    Log.e("ololo", "Ошибка: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("ololo", "Ошибка при загрузке данных: ${e.message}", e)
            }
        }
    }
}
