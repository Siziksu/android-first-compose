package com.siziksu.first_compose.domain.usecase

import com.siziksu.first_compose.domain.common.CoroutineCase
import com.siziksu.first_compose.domain.model.FilmDomain
import com.siziksu.first_compose.domain.repository.StudioGhibliRepositoryContract

class GetStudioGhibliFilms constructor(
    private val repository: StudioGhibliRepositoryContract
) : CoroutineCase<List<FilmDomain>, GetStudioGhibliFilms.Params>() {

    override suspend fun func(params: Params) = repository.getFilms()

    class Params
}
