package com.siziksu.port

import com.siziksu.domain.model.Film
import com.siziksu.port.model.FilmPort
import java.util.ArrayList

fun getFilmPortList(): List<FilmPort> {
    val list = ArrayList<FilmPort>()
    for (i in 0 until 2) {
        list.add(getFilmPort())
    }
    return list
}

fun getFilmPort() = FilmPort(
    "",
    "abc",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    listOf(),
    listOf(),
    listOf(),
    listOf(),
    ""
)

fun getFilmDomainList(): List<Film> {
    val list = ArrayList<Film>()
    for (i in 0 until 2) {
        list.add(getFilmDomain())
    }
    return list
}

fun getFilmDomain() = Film(
    "",
    "abc",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    listOf(),
    listOf(),
    listOf(),
    listOf(),
    ""
)
