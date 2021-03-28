package com.siziksu.first_compose.adapters.mapper

import com.siziksu.first_compose.common.Mapper
import com.siziksu.first_compose.domain.model.Film
import com.siziksu.first_compose.framework.ui.feature.main.ghibli.model.FilmUi

class FilmsDomainToUi : Mapper<Film, FilmUi>() {

    override fun map(unmapped: Film) = FilmUi(
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
