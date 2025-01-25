package com.example.hw3_compose.ui.theme.episode

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.hw3_compose.ui.theme.ViewModule.EpisodeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun EpisodeDetailScreen(episodeId: Int) {
    val episodeViewModel: EpisodeViewModel = koinViewModel()

    LaunchedEffect(episodeId) {
        episodeViewModel.loadEpisodeDetails(episodeId)
    }

    val episode = episodeViewModel.episodeDetails.collectAsState().value

    if (episode == null) {
        Text(text = "Загрузка...")
    } else {
        Column {
            Text(text = "Name: ${episode.name}")
            Text(text = "Air Date: ${episode.airDate}")
            Text(text = "Episode: ${episode.episode}")
        }
    }
}
