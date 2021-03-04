package com.siziksu.first_compose.data.datasource.api

import com.siziksu.first_compose.data.model.FilmData

class StudioGhibliDataSource(private val studioGhibliApi: StudioGhibliApi) {

    suspend fun getFilms(): List<FilmData> = studioGhibliApi.getFilms()
}
