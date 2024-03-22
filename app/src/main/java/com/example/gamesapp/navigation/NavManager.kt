package com.example.gamesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable("DetailView/{id}", arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        ) ){
            val id = it.arguments?.getInt("id") ?: 0
            DetailView(viewModel = viewModel, navController, id)
        }
    }
}