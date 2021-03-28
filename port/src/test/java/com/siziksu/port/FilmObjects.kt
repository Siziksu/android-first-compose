package com.siziksu.port

import com.siziksu.port.model.FilmPort
import java.util.ArrayList

fun getFilmPortList(): List<FilmPort> {
    val list = ArrayList<FilmPort>()
    for (i in 0 until 10) {
        list.add(getFilmPort())
    }
    return list
}

fun getFilmPort() = FilmPort(
    "",
    "",
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
