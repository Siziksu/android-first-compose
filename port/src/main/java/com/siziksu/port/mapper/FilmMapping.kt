package com.siziksu.port.mapper

import com.siziksu.domain.model.Film
import com.siziksu.port.model.FilmPort

fun Film.toLayerPort() = FilmPort(
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

fun FilmPort.toLayerDomain() = Film(
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
