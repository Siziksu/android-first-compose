package com.siziksu.first_compose.framework.ui.feature.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.siziksu.first_compose.R
import com.siziksu.first_compose.framework.ui.common.components.AppCard
import com.siziksu.first_compose.framework.ui.common.components.AppSurface
import com.siziksu.first_compose.framework.ui.theme.DpUnit

@Composable
fun HomeFeature() {
    AppSurface { HomeContent() }
}

@Composable
private fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DpUnit.VALUE_10, vertical = DpUnit.VALUE_10)
    ) {
        AppCard(
            title = R.string.info,
            content = {
                Text(
                    text = stringResource(R.string.home_info),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(DpUnit.VALUE_10)
                )
            }
        )
    }
}
