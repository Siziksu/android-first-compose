package com.siziksu.port.repository.contracts

import com.siziksu.port.model.FilmPort

interface StudioGhibliDataSourceContract {

    suspend fun getFilms(): List<FilmPort>
}
