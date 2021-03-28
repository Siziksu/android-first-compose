package com.siziksu.framework.api.ghibli

import com.siziksu.framework.api.ghibli.model.FilmApi
import retrofit2.http.GET

interface StudioGhibliApi {

    @GET("films")
    suspend fun getFilms(): List<FilmApi>
}
