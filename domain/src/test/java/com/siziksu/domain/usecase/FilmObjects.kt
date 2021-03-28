package com.siziksu.domain.usecase

import com.siziksu.domain.model.Film
import java.util.ArrayList

fun getFilmDomainList(): List<Film> {
    val list = ArrayList<Film>()
    for (i in 0 until 10) {
        list.add(getFilmDomain())
    }
    return list
}

fun getFilmDomain() = Film(
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
