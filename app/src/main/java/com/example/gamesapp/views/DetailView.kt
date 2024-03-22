package com.example.gamesapp.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.gamesapp.components.MainTopBar
import com.example.gamesapp.viewmodel.GameViewModel

@Composable
fun DetailView(viewModel: GameViewModel, navController: NavController, id:Int){

    LaunchedEffect(Unit) {
        viewModel.getGameById(id)
    }
    Scaffold(
        topBar = {
            MainTopBar(title = "DETALLE") {

            }
        }

    ) {
        ContentDetailsView(pad = it, viewModel =viewModel )
    }
}




@Composable
fun ContentDetailsView(pad:PaddingValues, viewModel: GameViewModel){
    Text(text = viewModel.state.name, color = Color.Black)
}