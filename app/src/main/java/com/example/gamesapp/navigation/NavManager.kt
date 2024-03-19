package com.example.gamesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamesapp.viewmodel.GameViewModel
import com.example.gamesapp.views.DetailView
import com.example.gamesapp.views.HomeView

@Composable
fun NavManager(viewModel: GameViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(viewModel, navController)
        }
        composable("DetailView"){
            DetailView(viewModel = viewModel, navController)
        }
    }
}