package com.siziksu.first_compose.ui.feature.main.ghibli.mapper

import com.siziksu.first_compose.common.Mapper
import com.siziksu.first_compose.domain.model.FilmDomain
import com.siziksu.first_compose.ui.feature.main.ghibli.model.Film

class FilmsDomainToUi : Mapper<FilmDomain, Film>() {

    override fun map(unmapped: FilmDomain) = Film(
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
