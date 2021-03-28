package com.siziksu.first_compose.adapters.repository.contracts

import com.siziksu.first_compose.adapters.model.FilmInad

interface StudioGhibliDataSourceContract {

    suspend fun getFilms(): List<FilmInad>
}
