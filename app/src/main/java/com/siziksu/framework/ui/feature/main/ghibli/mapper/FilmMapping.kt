package com.siziksu.framework.ui.feature.main.ghibli.mapper

import com.siziksu.framework.ui.feature.main.ghibli.model.FilmUi
import com.siziksu.port.model.FilmPort

fun FilmPort.toLayerUi() = FilmUi(
    id = id,
    title = title,
    originalTitle = originalTitle,
    originalTitleRomanised = originalTitleRomanised,
    description = description,
    director = director,
    producer = producer,
    releaseDate = releaseDate,
    runningTime = runningTime,
    rtScore = rtScore,
    people = people,
    species = species,
    locations = locations,
    vehicles = vehicles,
    url = url,
)
