package com.rago.pokedex.network

import com.rago.pokedex.data.CustomJson
import retrofit2.Call
import retrofit2.http.GET


interface PokeServices {
    @GET("pokemon")
    fun listRepos(): Call<CustomJson>
}