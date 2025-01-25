package com.example.hw3_compose.ui.theme.ViewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.ui.theme.data.dto.CharacterResponse
import com.example.hw3_compose.ui.theme.data.dto.CharacterResultResponse
import com.example.hw3_compose.ui.theme.data.repasitory.CharacterRepasitory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CharacterViewModule(
    private val characterRepasitory: CharacterRepasitory,
) : ViewModel() {

    private val _characters = MutableStateFlow<List<CharacterResponse>>(emptyList())
    val characters = _characters

    private val _characterDetails = MutableStateFlow<CharacterResponse?>(null)
    val characterDetails = _characterDetails

    init {
        fetchAllCharacters()
    }

    fun getCharacterDetails(id: Int) {
        viewModelScope.launch {
        try {
            val response = characterRepasitory.getCharacterDetails(id)
            if (response.isSuccessful && response.body() != null) {
                _characterDetails.value = response.body()
            } else {
                Log.e(
                    "ololo",
                    "Ошибка: ${response.code()} - ${response.message()}"
                )
            }
        }catch (e: Exception) {
            Log.e("ololo", "Ошибка при загрузке данных: ${e.message}", e)
        }
        }
    }
    fun fetchAllCharacters() {
        viewModelScope.launch {
            try {
                val response = characterRepasitory.fetchCharacters()
                if (response.isSuccessful && response.body() != null) {
                    _characters.value = response.body()!!.result
                } else {
                    Log.e(
                        "ololo",
                        "Ошибка: ${response.code()} - ${response.message()}"
                    )
                }
            } catch (e: Exception) {
                Log.e("ololo", "Ошибка при загрузке данных: ${e.message}", e)
            }
        }
    }
}