package com.rago.pokedex.data

import com.google.gson.annotations.SerializedName

data class CustomJson(

    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: String?,
    @SerializedName("results")
    var results: List<ItemPoke>
)


/*
* "count": 1118,
  "next": "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20",
  "previous": null,
  "results": [
* */