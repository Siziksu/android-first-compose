package com.siziksu.framework.api.ghibli

import com.siziksu.framework.api.ghibli.mapper.toLayerPort
import com.siziksu.port.model.FilmPort
import com.siziksu.port.repository.contracts.GhibliDataSourceContract

class GhibliDataSource(
    private val ghibliApi: GhibliApi
) : GhibliDataSourceContract {

    override suspend fun getFilms(): List<FilmPort> = ghibliApi.getFilms().map { it.toLayerPort() }
}
