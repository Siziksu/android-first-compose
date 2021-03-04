package com.siziksu.first_compose.data.datasource.api

import com.siziksu.first_compose.data.model.FilmData
import retrofit2.http.GET

interface StudioGhibliApi {

    @GET("films")
    suspend fun getFilms(): List<FilmData>
}
