package com.siziksu.framework.ui.feature.main.location

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.siziksu.framework.R
import com.siziksu.framework.ui.common.components.AppCard
import com.siziksu.framework.ui.common.components.AppSurface
import com.siziksu.framework.ui.theme.DpUnit
import com.siziksu.port.viewmodels.LocationViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun LocationFeature() {
    val model = getViewModel<LocationViewModel>().apply { init(LocalContext.current) }
    AppSurface { LocationState(model) }
}

@Composable
private fun LocationState(model: LocationViewModel) {
    val location: String by model.location.collectAsState()
    LocationContent(location)
}

@Composable
private fun LocationContent(location: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DpUnit.VALUE_10, vertical = DpUnit.VALUE_10)
    ) {
        AppCard(
            title = R.string.location,
            content = {
                Text(
                    text = if (location.isNotBlank()) location else stringResource(R.string.location_not_retrieved),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
            }
        )
    }
}
