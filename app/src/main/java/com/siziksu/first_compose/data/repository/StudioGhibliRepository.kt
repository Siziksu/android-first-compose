package com.siziksu.first_compose.data.repository

import com.siziksu.first_compose.data.datasource.api.StudioGhibliDataSource
import com.siziksu.first_compose.data.mapper.FilmsDataToDomain
import com.siziksu.first_compose.domain.model.FilmDomain
import com.siziksu.first_compose.domain.repository.StudioGhibliRepositoryContract

class StudioGhibliRepository(
    private val studioGhibliDataSource: StudioGhibliDataSource,
    private val filmsDataToDomain: FilmsDataToDomain
) : StudioGhibliRepositoryContract {

    override suspend fun getFilms(): List<FilmDomain> = filmsDataToDomain.map(studioGhibliDataSource.getFilms())
}
