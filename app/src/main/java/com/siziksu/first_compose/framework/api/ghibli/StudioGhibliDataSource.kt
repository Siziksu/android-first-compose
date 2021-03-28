package com.siziksu.first_compose.framework.api.ghibli

import com.siziksu.first_compose.adapters.model.FilmInad
import com.siziksu.first_compose.adapters.repository.contracts.StudioGhibliDataSourceContract
import com.siziksu.first_compose.framework.api.ghibli.mapper.FilmsApiToInad

class StudioGhibliDataSource(
    private val studioGhibliApi: StudioGhibliApi,
    private val filmsApiToInad: FilmsApiToInad
) : StudioGhibliDataSourceContract {

    override suspend fun getFilms(): List<FilmInad> = filmsApiToInad.map(studioGhibliApi.getFilms())
}
