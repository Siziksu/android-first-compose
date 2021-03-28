package com.siziksu.framework.ui.feature.main.ghibli.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.siziksu.framework.ui.common.components.AppCard
import com.siziksu.framework.ui.feature.main.ghibli.model.FilmUi
import com.siziksu.framework.ui.theme.AppColors
import com.siziksu.framework.ui.theme.DpUnit

@Composable
fun ListHeader(title: String) {
    AppCard {
        Box(
            modifier = Modifier
                .background(AppColors.Blue300)
                .padding(horizontal = DpUnit.VALUE_10, vertical = DpUnit.VALUE_5),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
fun ListItem(film: FilmUi) {
    AppCard(modifier = Modifier.padding(horizontal = DpUnit.VALUE_0, vertical = DpUnit.VALUE_5)) {
        Column(modifier = Modifier.padding(horizontal = DpUnit.VALUE_10, vertical = DpUnit.VALUE_10)) {
            Box(
                modifier = Modifier.padding(bottom = DpUnit.VALUE_5),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = film.title,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
            Divider(
                color = AppColors.Grey600,
                thickness = DpUnit.VALUE_1
            )
            Box(
                modifier = Modifier.padding(top = DpUnit.VALUE_5),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = StringBuilder().apply {
                        append("Year: ${film.releaseDate}\n")
                        append("Director: ${film.director}\n")
                        append("Duration: ${film.runningTime} min.\n\n")
                        append(film.description)
                    }.toString(),
                    style = MaterialTheme.typography.body1,
                )
            }
        }
    }
}
