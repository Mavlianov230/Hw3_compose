package com.example.hw3_compose.ui.theme.modul

import com.example.hw3_compose.ui.theme.ViewModule.CharacterViewModule
import com.example.hw3_compose.ui.theme.ViewModule.EpisodeViewModel
import com.example.hw3_compose.ui.theme.ViewModule.FavoriteCharacterViewModel
import com.example.hw3_compose.ui.theme.ViewModule.LocationViewModel
import com.example.hw3_compose.ui.theme.data.api.CharacterApiService
import com.example.hw3_compose.ui.theme.data.api.EpisodeApiService
import com.example.hw3_compose.ui.theme.data.api.LocationApiService
import com.example.hw3_compose.ui.theme.data.dto.AppDatabase
import com.example.hw3_compose.ui.theme.data.dto.FavoriteCharacterDao
import com.example.hw3_compose.ui.theme.data.repasitory.CharacterRepasitory
import com.example.hw3_compose.ui.theme.data.repasitory.FavoriteCharacterRepository
import com.example.hw3_compose.ui.theme.data.repository.EpisodeRepository
import com.example.hw3_compose.ui.theme.data.repository.LocationRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {


    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .callTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()

    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }




    single { get<Retrofit>().create(CharacterApiService::class.java) }
    single { get<Retrofit>().create(EpisodeApiService::class.java) }
    single { get<Retrofit>().create(LocationApiService::class.java) }

    single { CharacterRepasitory(get()) }
    single { EpisodeRepository(get()) }
    single { LocationRepository(get()) }
    single { FavoriteCharacterRepository(get()) }
    single { FavoriteCharacterRepository(get()) }
    //single { FavoriteCharacterDao(get()) }

    viewModel { CharacterViewModule(get()) }
    viewModel { EpisodeViewModel(get()) }
    viewModel { LocationViewModel(get()) }
    viewModel { FavoriteCharacterViewModel(get()) }
}
