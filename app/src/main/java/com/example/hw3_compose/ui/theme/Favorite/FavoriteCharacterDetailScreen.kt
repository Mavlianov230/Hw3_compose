package com.example.hw3_compose.ui.theme.Favorite

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FavoriteCharacterDetailScreen(characterId: Int, onBack: () -> Unit) {
    Text(text = " ID: $characterId")
}
