package com.example.hw3_compose.ui.theme.modul

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hw3_compose.ui.theme.ViewModule.CharacterViewModule
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
   viewModel { CharacterViewModule(get()) }
}