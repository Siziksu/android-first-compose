package com.siziksu.framework

import com.siziksu.framework.api.ghibli.model.FilmApi
import java.util.ArrayList

fun getFilmApiList(): List<FilmApi> {
    val list = ArrayList<FilmApi>()
    for (i in 0 until 10) {
        list.add(getFilmDomain())
    }
    return list
}

fun getFilmDomain() = FilmApi(
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
