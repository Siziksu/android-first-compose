package com.siziksu.first_compose.domain.repository

import com.siziksu.first_compose.domain.model.FilmDomain

interface StudioGhibliRepositoryContract {

    suspend fun getFilms(): List<FilmDomain>
}
