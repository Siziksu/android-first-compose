package com.siziksu.framework.api.ghibli.mapper

import com.siziksu.framework.api.ghibli.model.FilmApi
import com.siziksu.port.model.FilmPort

fun FilmApi.toLayerPort() = FilmPort(
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
