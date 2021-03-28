package com.siziksu.first_compose.domain.contracts

import com.siziksu.first_compose.domain.model.Film

interface StudioGhibliContract {

    suspend fun getFilms(): List<Film>
}
