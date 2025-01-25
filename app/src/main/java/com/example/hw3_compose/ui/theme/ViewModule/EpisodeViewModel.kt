package com.example.hw3_compose.ui.theme.ViewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.ui.theme.data.repository.EpisodeRepository
import com.example.hw3_compose.ui.theme.episode.Episode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EpisodeViewModel(private val episodeRepository: EpisodeRepository) : ViewModel() {

    private val _episodes = MutableStateFlow<List<Episode>>(emptyList())
    val episodes: StateFlow<List<Episode>> = _episodes

    private val _episodeDetails = MutableStateFlow<Episode?>(null)
    val episodeDetails: StateFlow<Episode?> = _episodeDetails

    fun loadEpisodes() {
        viewModelScope.launch {
            try {
                val response = episodeRepository.getEpisodes()
                if (response.isSuccessful) {
                    _episodes.value = response.body()?.results ?: emptyList()
                }
            } catch (e: Exception) {
                Log.e("ololo", "Ошибка при загрузке данных: ${e.message}", e)

            }
        }
    }

    fun loadEpisodeDetails(id: Int) {
        viewModelScope.launch {
            try {
                val response = episodeRepository.getEpisodeDetails(id)
                if (response.isSuccessful) {
                    _episodeDetails.value = response.body()
                }
            } catch (e: Exception) {
                Log.e("ololo", "Ошибка при загрузке данных: ${e.message}", e)

            }
        }
    }
}
