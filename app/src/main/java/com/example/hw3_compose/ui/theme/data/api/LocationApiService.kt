package com.example.hw3_compose.ui.theme.data.api


import com.example.hw3_compose.ui.theme.location.LocationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApiService {
    @GET("locations")
    suspend fun getLocations(): Response<LocationResponse>

    @GET("location_detail/{id}")
    suspend fun getLocationDetails(@Path("id") id: Int): Response<LocationResponse.Location>
}
