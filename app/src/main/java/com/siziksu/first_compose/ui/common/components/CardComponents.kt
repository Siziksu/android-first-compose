package com.siziksu.first_compose.ui.common.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import com.siziksu.first_compose.R
import com.siziksu.first_compose.ui.theme.AppColors
import com.siziksu.first_compose.ui.theme.DpUnit
import java.util.Locale

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    content: @Composable () -> Unit = {}
) {
    Card(modifier = modifier.fillMaxWidth(), shape = shape, backgroundColor = backgroundColor) {
        content()
    }
}

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    title: Int = -1,
    onClick: (() -> Unit)? = null,
    buttonTitle: Int = -1,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = AppColors.Blue500,
    dividerColor: Color = AppColors.Blue200,
    contentVisibility: Boolean = true,
    content: @Composable () -> Unit = {},
    footer: (@Composable () -> Unit)? = null
) {
    AppCard(
        modifier,
        stringResource(
            id = if (title != -1) {
                title
            } else {
                R.string.app_name
            }
        ), onClick, buttonTitle, shape, backgroundColor, dividerColor, contentVisibility, content, footer
    )
}

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    title: String,
    onClick: (() -> Unit)? = null,
    buttonTitle: Int = -1,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = AppColors.Blue500,
    dividerColor: Color = AppColors.Blue200,
    contentVisibility: Boolean = true,
    content: @Composable () -> Unit = {},
    footer: (@Composable () -> Unit)? = null
) {
    Card(modifier = modifier.fillMaxWidth(), shape = shape, backgroundColor = backgroundColor) {
        Column(modifier = Modifier.padding(horizontal = DpUnit.VALUE_10, vertical = DpUnit.VALUE_5)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(DpUnit.VALUE_5),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                onClick?.let { action ->
                    Text(
                        text = stringResource(
                            id = if (buttonTitle != -1) {
                                buttonTitle
                            } else {
                                R.string.about
                            }
                        ).toUpperCase(Locale.getDefault()),
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .clickable { action() }
                    )
                }
            }
            CardContent(dividerColor, contentVisibility, content, footer)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CardContent(
    dividerColor: Color = AppColors.Blue200,
    contentVisibility: Boolean = true,
    content: @Composable () -> Unit = {},
    footer: (@Composable () -> Unit)? = null
) {
    AnimatedVisibility(visible = contentVisibility) {
        Column {
            Divider(
                color = dividerColor,
                thickness = DpUnit.VALUE_1,
                modifier = Modifier.padding(start = DpUnit.VALUE_5, end = DpUnit.VALUE_5)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(DpUnit.VALUE_5)
            ) {
                content()
                footer?.let {
                    Divider(
                        color = dividerColor,
                        thickness = DpUnit.VALUE_1,
                        startIndent = DpUnit.VALUE_100,
                        modifier = Modifier.padding(top = DpUnit.VALUE_10, bottom = DpUnit.VALUE_5)
                    )
                    it()
                }
            }
        }
    }
}
