package com.example.hw3_compose.ui.theme.data.repasitory

import com.example.hw3_compose.ui.theme.data.api.CharacterApiService
import com.example.hw3_compose.ui.theme.data.dto.CharacterResponse
import com.example.hw3_compose.ui.theme.data.dto.CharacterResultResponse
import retrofit2.Response

class CharacterRepasitory (
    private val apiService: CharacterApiService
){
    suspend fun fetchCharacters(): Response<CharacterResultResponse> {
       return  apiService.fetchCharacters()
    }

    suspend fun getCharacterDetails(id: Int): Response<CharacterResponse> {
        return apiService.getCharacterById(id)
    }
}