package com.siziksu.first_compose.data.model

import com.google.gson.annotations.SerializedName

data class FilmData(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("original_title_romanised")
    val originalTitleRomanised: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("producer")
    val producer: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("running_time")
    val runningTime: String,
    @SerializedName("rt_score")
    val rtScore: String,
    @SerializedName("people")
    val people: List<String>,
    @SerializedName("species")
    val species: List<String>,
    @SerializedName("locations")
    val locations: List<String>,
    @SerializedName("vehicles")
    val vehicles: List<String>,
    @SerializedName("url")
    val url: String
)
