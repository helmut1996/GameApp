package com.example.gamesapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gamesapp.components.MainImage
import com.example.gamesapp.components.MainTopBar
import com.example.gamesapp.components.MetaWebsite
import com.example.gamesapp.components.ReviewCard
import com.example.gamesapp.util.Constans
import com.example.gamesapp.viewmodel.GameViewModel

@Composable
fun DetailView(viewModel: GameViewModel, navController: NavController, id: Int) {

    LaunchedEffect(Unit) {
        viewModel.getGameById(id)
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.clean()
        }
    }

    Scaffold(
        topBar = {
            MainTopBar(title = viewModel.state.name, showBackButton = true ,onClickBackButton = {
                navController.popBackStack() }) {}
        }

    ) {
        ContentDetailsView(pad = it, viewModel = viewModel)
    }
}


@Composable
fun ContentDetailsView(pad: PaddingValues, viewModel: GameViewModel) {
    val state = viewModel.state

    Column(
        modifier = Modifier
            .padding(pad)
            .background(Color(Constans.COMSTOM_COLOR))
    ) {
        MainImage(image = state.background_image)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 5.dp)
        ) {
            MetaWebsite(url = state.website)
            ReviewCard(metascore = state.metacritic)
        }

        val scroll = rememberScrollState(0)
        Text(text = state.description_raw,
            color = Color.White,
            textAlign = TextAlign.Justify,
            modifier= Modifier
                .padding(start = 15.dp, end = 15.dp, bottom = 10.dp)
                .verticalScroll(scroll)
        )

    }
}