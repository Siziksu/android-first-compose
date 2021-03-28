package com.siziksu.domain.usecase

import com.siziksu.domain.common.CoroutineCase
import com.siziksu.domain.contracts.StudioGhibliContract
import com.siziksu.domain.model.Film
import com.siziksu.domain.usecase.GetStudioGhibliFilms.Params

class GetStudioGhibliFilms constructor(
    private val studioGhibli: StudioGhibliContract
) : CoroutineCase<List<Film>, Params>() {

    override suspend fun func(params: Params): List<Film> = studioGhibli.getFilms()

    class Params
}
