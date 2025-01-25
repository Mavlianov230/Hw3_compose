package com.example.hw3_compose.ui.theme.data.dto

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import com.example.hw3_compose.ui.theme.Favorite.FavoriteCharacter
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCharacterDao {
    @Insert
    suspend fun addCharacterToFavorites(character: FavoriteCharacter)

    @Delete
    suspend fun removeCharacterFromFavorites(character: FavoriteCharacter)

    @Query("SELECT * FROM favorite_characters")
    fun getAllFavoriteCharacters(): Flow<List<FavoriteCharacter>>
}
