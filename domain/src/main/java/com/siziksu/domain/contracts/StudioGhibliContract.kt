package com.siziksu.domain.contracts

import com.siziksu.domain.model.Film

interface StudioGhibliContract {

    suspend fun getFilms(): List<Film>
}
