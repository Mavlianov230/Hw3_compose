package com.example.hw3_compose.ui.theme.data.api

import com.example.hw3_compose.ui.theme.episode.Episode
import com.example.hw3_compose.ui.theme.episode.EpisodeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeApiService {
    @GET("episodes")
    suspend fun getEpisodes(): Response<EpisodeResponse>

    @GET("episode_detail/{id}")
    suspend fun getEpisodeDetails(@Path("id") id: Int): Response<Episode>
}
