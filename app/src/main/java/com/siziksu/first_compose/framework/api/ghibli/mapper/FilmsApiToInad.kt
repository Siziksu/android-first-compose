package com.siziksu.first_compose.framework.api.ghibli.mapper

import com.siziksu.first_compose.adapters.model.FilmInad
import com.siziksu.first_compose.common.Mapper
import com.siziksu.first_compose.framework.api.ghibli.model.FilmApi

class FilmsApiToInad : Mapper<FilmApi, FilmInad>() {

    override fun map(unmapped: FilmApi) = FilmInad(
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
