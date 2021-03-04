package com.siziksu.first_compose.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siziksu.first_compose.ui.screen.MainScreenState

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Start() }
    }

    @Composable
    fun Start() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = ROUTE_MAIN) {
            composable(ROUTE_MAIN) { MainScreenState() }
        }
    }

    companion object {

        const val ROUTE_MAIN = "route:main"
    }
}
