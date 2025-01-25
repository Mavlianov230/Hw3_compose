package com.example.hw3_compose.ui.theme.episode

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.hw3_compose.ui.theme.ViewModule.EpisodeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun EpisodesScreen(navController: NavController) {
    val viewModel: EpisodeViewModel = koinViewModel()
    val episodes = viewModel.episodes.collectAsState().value

    LazyColumn {
        items(episodes) { episode ->
            Text(
                text = episode.name,
                modifier = Modifier.clickable {
                    navController.navigate("episode_detail/${episode.id}")
                }
            )
        }
    }
}
