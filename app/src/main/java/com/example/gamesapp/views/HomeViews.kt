package com.example.gamesapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gamesapp.components.CardGames
import com.example.gamesapp.components.MainTopBar
import com.example.gamesapp.util.Constans.Companion.COMSTOM_COLOR
import com.example.gamesapp.viewmodel.GameViewModel

@Composable
fun HomeView(gameViewModel: GameViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            MainTopBar(title = "API GAMES") {

            }
        }
    ) {
        ContentsHomeView(gameViewModel = gameViewModel, pad = it)
    }
}


@Composable
fun ContentsHomeView(gameViewModel: GameViewModel, pad: PaddingValues) {
    val games by gameViewModel.games.collectAsState()
    LazyColumn(
        modifier = Modifier.padding(pad)
            .background(Color(COMSTOM_COLOR))
    ) {
        items(games) { item ->
            CardGames(game = item) {

            }
            Text(
                text = item.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}