package com.siziksu.first_compose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Theaters
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.siziksu.first_compose.R
import com.siziksu.first_compose.ui.common.components.HomeTabBar
import com.siziksu.first_compose.ui.common.components.HomeTopBar
import com.siziksu.first_compose.ui.common.model.MainTab
import com.siziksu.first_compose.ui.feature.main.ghibli.GhibliFeature
import com.siziksu.first_compose.ui.feature.main.home.HomeFeature
import com.siziksu.first_compose.ui.feature.main.location.LocationFeature
import com.siziksu.first_compose.ui.theme.AppComposeTheme

@Composable
fun MainScreenState() {
    val home = stringResource(id = R.string.home)
    val location = stringResource(id = R.string.location)
    val ghibliFilms = stringResource(id = R.string.ghibli_films)
    val tabs = mutableMapOf<String, MainTab>()
    tabs[home] = MainTab(Filled.Home, home) { HomeFeature() }
    tabs[location] = MainTab(Filled.LocationOn, location) { LocationFeature() }
    tabs[ghibliFilms] = MainTab(Filled.Theaters, ghibliFilms) { GhibliFeature() }
    var currentTab by remember { mutableStateOf(tabs[home]) }
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
                currentTab?.content?.invoke()
            }
        }
    }
}

