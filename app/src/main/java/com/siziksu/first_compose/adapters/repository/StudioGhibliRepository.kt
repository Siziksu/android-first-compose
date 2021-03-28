package com.siziksu.first_compose.adapters.repository

import com.siziksu.first_compose.adapters.mapper.FilmsInadToDomain
import com.siziksu.first_compose.adapters.repository.contracts.StudioGhibliDataSourceContract
import com.siziksu.first_compose.domain.contracts.StudioGhibliContract
import com.siziksu.first_compose.domain.model.Film

class StudioGhibliRepository(
    private val studioGhibliDataSource: StudioGhibliDataSourceContract,
    private val filmsInadToDomain: FilmsInadToDomain
) : StudioGhibliContract {

    override suspend fun getFilms(): List<Film> = filmsInadToDomain.map(studioGhibliDataSource.getFilms())
}
