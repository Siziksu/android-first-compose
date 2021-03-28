package com.siziksu.port.repository

import com.siziksu.domain.contracts.StudioGhibliContract
import com.siziksu.domain.model.Film
import com.siziksu.port.mapper.toLayerDomain
import com.siziksu.port.repository.contracts.StudioGhibliDataSourceContract

class StudioGhibliRepository(
    private val studioGhibliDataSource: StudioGhibliDataSourceContract
) : StudioGhibliContract {

    override suspend fun getFilms(): List<Film> = studioGhibliDataSource.getFilms().map { it.toLayerDomain() }
}
