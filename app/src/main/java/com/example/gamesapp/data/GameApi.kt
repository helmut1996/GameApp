package com.example.gamesapp.data

import com.example.gamesapp.model.GamesModel
import com.example.gamesapp.util.Constans.Companion.API_KEY
import com.example.gamesapp.util.Constans.Companion.ENPOINT
import retrofit2.Response
import retrofit2.http.GET

interface GameApi {
    @GET(ENPOINT + API_KEY)
    suspend fun getGames(): Response<GamesModel>
}