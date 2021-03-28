package com.siziksu.framework.api.ghibli

import com.siziksu.framework.api.ghibli.mapper.toLayerPort
import com.siziksu.port.model.FilmPort
import com.siziksu.port.repository.contracts.StudioGhibliDataSourceContract

class StudioGhibliDataSource(
    private val studioGhibliApi: StudioGhibliApi
) : StudioGhibliDataSourceContract {

    override suspend fun getFilms(): List<FilmPort> = studioGhibliApi.getFilms().map { it.toLayerPort() }
}
