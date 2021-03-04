package com.siziksu.first_compose.data.mapper

import com.siziksu.first_compose.common.Mapper
import com.siziksu.first_compose.data.model.FilmData
import com.siziksu.first_compose.domain.model.FilmDomain

class FilmsDataToDomain : Mapper<FilmData, FilmDomain>() {

    override fun map(unmapped: FilmData) = FilmDomain(
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
