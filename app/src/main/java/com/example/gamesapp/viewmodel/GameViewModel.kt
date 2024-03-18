package com.example.gamesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
}