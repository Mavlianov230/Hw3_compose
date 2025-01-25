package com.example.hw3_compose.ui.theme.ViewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.ui.theme.Favorite.FavoriteCharacter
import com.example.hw3_compose.ui.theme.data.repasitory.FavoriteCharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteCharacterViewModel(
    private val favoriteCharacterRepository: FavoriteCharacterRepository
) : ViewModel() {
    private val _favoriteCharacters = MutableStateFlow<List<FavoriteCharacter>>(emptyList())
    val favoriteCharacters: StateFlow<List<FavoriteCharacter>> = _favoriteCharacters

    init {
        Log.d("FavoriteCharacterViewModel", "ViewModel инициализирован")
    }

    private fun loadFavoriteCharacters() {
        viewModelScope.launch {
            favoriteCharacterRepository.getAllFavoriteCharacters().collect { characters ->
                _favoriteCharacters.value = characters
            }
        }
    }

    fun removeCharacterFromFavorites(character: FavoriteCharacter) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteCharacterRepository.removeCharacterFromFavorites(character)
        }
    }

}
