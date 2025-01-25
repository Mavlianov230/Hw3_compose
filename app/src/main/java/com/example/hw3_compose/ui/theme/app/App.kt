package com.example.hw3_compose.ui.theme.app

import android.app.Application
import com.example.hw3_compose.ui.theme.data.servicelocator.dataModule
import com.example.hw3_compose.ui.theme.modul.appModule
import com.example.hw3_compose.ui.theme.modul.uiModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(dataModule, uiModule, appModule)
        }
    }
}