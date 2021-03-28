package com.siziksu.framework.ui.feature.main.ghibli.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmUi(
    val id: String,
    val title: String,
    val originalTitle: String,
    val originalTitleRomanised: String,
    val description: String,
    val director: String,
    val producer: String,
    val releaseDate: String,
    val runningTime: String,
    val rtScore: String,
    val people: List<String>,
    val species: List<String>,
    val locations: List<String>,
    val vehicles: List<String>,
    val url: String
) : Parcelable
