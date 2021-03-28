package com.siziksu.first_compose.adapters.mapper

import com.siziksu.first_compose.adapters.model.FilmInad
import com.siziksu.first_compose.common.Mapper
import com.siziksu.first_compose.domain.model.Film

class FilmsInadToDomain : Mapper<FilmInad, Film>() {

    override fun map(unmapped: FilmInad) = Film(
        id = unmapped.id,
        title = unmapped.title,
        originalTitle = unmapped.originalTitle,
        originalTitleRomanised = unmapped.originalTitleRomanised,
        description = unmapped.description,
        director = unmapped.director,
        producer = unmapped.producer,
        releaseDate = unmapped.releaseDate,
        runningTime = unmapped.runningTime,
        rtScore = unmapped.rtScore,
        people = unmapped.people,
        species = unmapped.species,
        locations = unmapped.locations,
        vehicles = unmapped.vehicles,
        url = unmapped.url,
    )
}
