package com.example.hw3_compose.ui.theme.location

data class LocationResponse(
    val results: List<Location>
) {
    data class Location(
        val id: Int,
        val name: String,
        val type: String,
        val dimension: String,
        val imageUrl: String? = null
    )
}