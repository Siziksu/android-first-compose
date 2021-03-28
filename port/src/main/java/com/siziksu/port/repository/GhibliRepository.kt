package com.siziksu.port.repository

import com.siziksu.domain.contracts.GhibliRepositoryContract
import com.siziksu.domain.model.Film
import com.siziksu.port.mapper.toLayerDomain
import com.siziksu.port.repository.contracts.GhibliDataSourceContract

class GhibliRepository(
    private val ghibliDataSource: GhibliDataSourceContract
) : GhibliRepositoryContract {

    override suspend fun getFilms(): List<Film> = ghibliDataSource.getFilms().map { it.toLayerDomain() }
}
