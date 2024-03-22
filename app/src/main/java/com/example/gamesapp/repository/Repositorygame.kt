package com.example.gamesapp.repository

import com.example.gamesapp.data.GameApi
import com.example.gamesapp.model.GameList
import com.example.gamesapp.model.SingleGameModel
import javax.inject.Inject

class Repositorygame @Inject constructor(private val apiGames:GameApi) {

    suspend fun  getGame():List<GameList>? {
        val response = apiGames.getGames()
        if (response.isSuccessful){
            return response.body()?.results
        }
        return null
    }

    suspend fun getGamesById(id:Int):SingleGameModel? {
        val response = apiGames.getGamesById(id)
        if (response.isSuccessful){
            return response.body()
        }
        return null
    }
}