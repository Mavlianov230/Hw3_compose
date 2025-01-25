package com.example.hw3_compose.ui.theme.charakter

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.hw3_compose.ui.theme.ViewModule.CharacterViewModule
import com.example.hw3_compose.ui.theme.modul.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharactersScreen(navController: NavController) {
    val characterViewModel: CharacterViewModule = koinViewModel()
    val characters = characterViewModel.characters.collectAsState().value

    LazyColumn {
        if (characters.isEmpty()) {
            item { Text(text = "Загрузка...") }
        } else {
            items(characters) { character ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("character_detail/${character.id}")
                        }
                ) {
                    Image(
                        painter = rememberImagePainter(character.image),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = character.name)
                        Text(text = character.status)
                    }
                }
            }
        }
    }
}
