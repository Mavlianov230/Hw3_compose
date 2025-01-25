package com.example.hw3_compose.ui.theme.Favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.hw3_compose.ui.theme.ViewModule.FavoriteCharacterViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritesScreen(navController: NavController) {
    val favoriteCharacterViewModel: FavoriteCharacterViewModel = koinViewModel()
    val favoriteCharacters = favoriteCharacterViewModel.favoriteCharacters.collectAsState().value

    LazyColumn {
        if (favoriteCharacters.isEmpty()) {
            item { Text(text = "Нет избранных персонажей") }
        } else {
            items(favoriteCharacters) { character ->
                FavoriteCharacterItem(character, favoriteCharacterViewModel)
            }
        }
    }
}

@Composable
fun FavoriteCharacterItem(character: FavoriteCharacter, viewModel: FavoriteCharacterViewModel) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = character.name)
            }
            IconButton(onClick = { viewModel.removeCharacterFromFavorites(character) }) {
                Icon(Icons.Default.Delete, contentDescription = "Удалить из избранного")
            }
        }
    }
}
