package com.siziksu.first_compose.domain.usecase

import com.siziksu.first_compose.domain.common.CoroutineCase
import com.siziksu.first_compose.domain.contracts.StudioGhibliContract
import com.siziksu.first_compose.domain.model.Film

class GetStudioGhibliFilms constructor(
    private val studioGhibli: StudioGhibliContract
) : CoroutineCase<List<Film>, GetStudioGhibliFilms.Params>() {

    override suspend fun func(params: Params): List<Film> = studioGhibli.getFilms()

    class Params
}
