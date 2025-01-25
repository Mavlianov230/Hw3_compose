package com.example.hw3_compose.ui.theme.charakter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.hw3_compose.ui.theme.ViewModule.CharacterViewModule
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterDetailScreen(characterId: Int, onBack: () -> Unit) {
    val characterViewModel: CharacterViewModule = koinViewModel()

    LaunchedEffect(characterId) {
        characterViewModel.getCharacterDetails(characterId)
    }

    val character = characterViewModel.characterDetails.collectAsState().value

    if (character == null) {
        Text(text = "Загрузка...")
    } else {
        Column {
            Image(
                painter = rememberImagePainter(character.image),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Text(text = character.name)
            Text(text = "Status: ${character.status}")
            Button(onClick = onBack) {
                Text(text = "Назад")
            }
        }
    }
}
