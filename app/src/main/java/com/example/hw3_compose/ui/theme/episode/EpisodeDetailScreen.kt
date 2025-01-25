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
    val viewModel: EpisodeViewModel = koinViewModel()

    LaunchedEffect(episodeId) {
        viewModel.loadEpisodeDetails(episodeId)
    }

    val episode = viewModel.episodeDetails.collectAsState().value

    episode?.let {
        Column {
            Text(text = "Name: ${it.name}")
            Text(text = "Air Date: ${it.airDate}")
            Text(text = "Episode: ${it.episode}")
        }
    } ?: Text(text = "Loading...")
}
