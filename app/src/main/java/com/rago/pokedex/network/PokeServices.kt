package com.rago.pokedex.network

import com.rago.pokedex.data.CustomJson
import com.rago.pokedex.data.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface PokeServices {
    @GET("pokemon")
    fun listRepos(): Call<CustomJson>

    @GET("pokemon/{idPoke}")
    fun getPokemon(@Path("idPoke") idPoke: String): Call<Pokemon>
}