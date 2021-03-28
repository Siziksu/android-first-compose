package com.siziksu.domain.contracts

import com.siziksu.domain.model.Film

interface GhibliRepositoryContract {

    suspend fun getFilms(): List<Film>
}
