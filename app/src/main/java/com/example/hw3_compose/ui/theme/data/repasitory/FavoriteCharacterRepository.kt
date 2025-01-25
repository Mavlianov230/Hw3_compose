package com.example.hw3_compose.ui.theme.data.repasitory

import com.example.hw3_compose.ui.theme.Favorite.FavoriteCharacter
import com.example.hw3_compose.ui.theme.data.dto.FavoriteCharacterDao
import kotlinx.coroutines.flow.Flow

class FavoriteCharacterRepository(
    private val favoriteCharacterDao: FavoriteCharacterDao
) {


    fun getAllFavoriteCharacters(): Flow<List<FavoriteCharacter>> {
        return favoriteCharacterDao.getAllFavoriteCharacters()
    }

    suspend fun addCharacterToFavorites(character: FavoriteCharacter) {
        favoriteCharacterDao.addCharacterToFavorites(character)
    }

    suspend fun removeCharacterFromFavorites(character: FavoriteCharacter) {
        favoriteCharacterDao.removeCharacterFromFavorites(character)
    }
}
