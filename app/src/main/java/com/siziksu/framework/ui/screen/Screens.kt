package com.siziksu.framework.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Theaters
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.siziksu.framework.R
import com.siziksu.framework.ui.common.components.HomeTabBar
import com.siziksu.framework.ui.common.components.HomeTopBar
import com.siziksu.framework.ui.common.model.Content
import com.siziksu.framework.ui.common.model.MainTab
import com.siziksu.framework.ui.feature.main.ghibli.GhibliFeature
import com.siziksu.framework.ui.feature.main.home.HomeFeature
import com.siziksu.framework.ui.feature.main.location.LocationFeature
import com.siziksu.framework.ui.theme.AppComposeTheme

@Composable
fun MainScreenState() {
    val home = stringResource(id = R.string.home)
    val location = stringResource(id = R.string.location)
    val ghibliFilms = stringResource(id = R.string.ghibli_films)
    val tabs = mutableMapOf<String, MainTab>()
    tabs[home] = MainTab(home, Content.HOME).apply { icon = Icons.Filled.Home }
    tabs[location] = MainTab(location, Content.LOCATION).apply { icon = Icons.Filled.LocationOn }
    tabs[ghibliFilms] = MainTab(ghibliFilms, Content.GHIBLI).apply { icon = Icons.Filled.Theaters }
    var currentTab by rememberSaveable { mutableStateOf(tabs[home]) }
    MainScreen(tabs, currentTab) { currentTab = it }
}

@Composable
fun MainScreen(tabs: MutableMap<String, MainTab>, currentTab: MainTab?, onTabSelected: (MainTab) -> Unit) {
    AppComposeTheme {
        Scaffold(topBar = {
            HomeTopBar(title = currentTab?.title)
        }) {
            Column {
                HomeTabBar(tabs = tabs, currentTab = currentTab, onTabSelected = { tab -> onTabSelected(tab) })
                when (currentTab?.content) {
                    Content.HOME -> HomeFeature()
                    Content.LOCATION -> LocationFeature()
                    Content.GHIBLI -> GhibliFeature()
                }
            }
        }
    }
}
