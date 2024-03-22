package com.example.gamesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesapp.State.GameState
import com.example.gamesapp.model.GameList
import com.example.gamesapp.repository.Repositorygame
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(private val repository: Repositorygame) : ViewModel() {

    private val _game = MutableStateFlow<List<GameList>>(emptyList())
    val games = _game.asStateFlow()

    var state by mutableStateOf(GameState())
    private set

    init {
        fetchGame()
    }

    private fun fetchGame() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getGame()
                _game.value = result ?: emptyList()
            }
        }
    }

fun getGameById(id:Int){
    viewModelScope.launch {
        withContext(Dispatchers.IO){
            val result = repository.getGamesById(id)
            state = state.copy(
                name = result?.name ?: "",
                description_raw = result?.description_raw ?: "",
                metacritic = result?.metacritic ?: 111,
                website = result?.website ?: "sin web",
                background_image = result?.background_image ?: ""
            )
        }
    }
}

     fun clean(){
         state = state.copy(
             name ="",
             description_raw = "",
             metacritic =  111,
             website =  "sin web",
             background_image =  ""
         )
     }
}