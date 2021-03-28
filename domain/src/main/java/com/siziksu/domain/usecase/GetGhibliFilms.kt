package com.siziksu.domain.usecase

import com.siziksu.domain.common.CoroutineCase
import com.siziksu.domain.contracts.GhibliRepositoryContract
import com.siziksu.domain.model.Film

class GetGhibliFilms constructor(
    private val ghibliRepository: GhibliRepositoryContract
) : CoroutineCase<List<Film>, GetGhibliFilms.Params>() {

    override suspend fun func(params: Params): List<Film> = ghibliRepository.getFilms()

    class Params
}
