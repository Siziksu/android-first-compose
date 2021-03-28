package com.siziksu.port.repository.contracts

import com.siziksu.port.model.FilmPort

interface GhibliDataSourceContract {

    suspend fun getFilms(): List<FilmPort>
}
