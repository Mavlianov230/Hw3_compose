package com.example.hw3_compose.ui.theme.data.repository

import com.example.hw3_compose.ui.theme.data.api.EpisodeApiService
import com.example.hw3_compose.ui.theme.episode.Episode

class EpisodeRepository(private val episodeApiService: EpisodeApiService) {

    suspend fun getEpisodes() = episodeApiService.getEpisodes()

    suspend fun getEpisodeDetails(id: Int) = episodeApiService.getEpisodeDetails(id)
}
