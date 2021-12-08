package com.rago.pokedex.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApi {

    @Volatile
    private var instance: Retrofit? = null

    fun getInstance(): Retrofit? {
        if (instance != null) {
            return instance
        }

        return synchronized(this) {
            return if (instance != null) {
                instance
            } else {
                Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
        }
    }


}

/*
* Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .build();

GitHubService service = retrofit.create(GitHubService.class);
* */