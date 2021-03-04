package com.siziksu.first_compose.ui.feature.main.ghibli

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.siziksu.first_compose.ui.common.components.AppSurface
import com.siziksu.first_compose.ui.feature.main.ghibli.components.ListHeader
import com.siziksu.first_compose.ui.feature.main.ghibli.components.ListItem
import com.siziksu.first_compose.ui.feature.main.ghibli.model.Film
import com.siziksu.first_compose.ui.theme.DpUnit
import org.koin.androidx.compose.getViewModel

@Composable
fun GhibliFeature() {
    val model = getViewModel<GhibliViewModel>().apply { getStudioGhibliFilms() }
    AppSurface { FilmsState(model) }
}

@Composable
private fun FilmsState(model: GhibliViewModel) {
    val films: List<Film> by model.films.collectAsState()
    GhibliContent(films)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun GhibliContent(films: List<Film>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DpUnit.VALUE_10, vertical = DpUnit.VALUE_10)
    ) {
        LazyColumn {
            val grouped = films.groupBy { it.title[0] }
            for ((initial, list) in grouped) {
                stickyHeader { ListHeader(initial.toString()) }
                items(list) { film -> ListItem(film) }
            }
        }
    }
}
