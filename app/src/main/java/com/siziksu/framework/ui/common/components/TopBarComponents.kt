package com.siziksu.framework.ui.common.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.siziksu.framework.R
import com.siziksu.framework.ui.common.model.MainTab
import com.siziksu.framework.ui.theme.AppColors
import com.siziksu.framework.ui.theme.DpUnit
import java.util.Locale

@Composable
fun HomeTopBar(title: String? = null) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = AppColors.Blue500,
        elevation = DpUnit.VALUE_5
    ) {

        Text(
            text = title ?: stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(horizontal = DpUnit.VALUE_15, vertical = DpUnit.VALUE_15)
                .fillMaxWidth()
        )
    }
}

@Composable
fun HomeTabBar(
    tabs: MutableMap<String, MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit
) {
    Surface(
        color = AppColors.Blue500,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.selectableGroup()) {
            tabs.forEach { (_, tab) ->
                AppTab(
                    text = tab.title.toUpperCase(Locale.getDefault()),
                    icon = tab.icon,
                    selected = currentTab == tab,
                    onSelected = { onTabSelected(tab) }
                )
            }
        }
    }
}

@Composable
fun SimpleTopBar(title: Int = -1) {
    SimpleTopBar(if (title != -1) stringResource(id = title) else null)
}

@Composable
fun SimpleTopBar(title: String? = null) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = AppColors.Blue500,
        elevation = DpUnit.VALUE_5
    ) {
        Text(
            text = title ?: stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(horizontal = DpUnit.VALUE_15, vertical = DpUnit.VALUE_15)
                .fillMaxWidth()
        )
    }
}
