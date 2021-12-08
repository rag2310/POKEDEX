package com.rago.pokedex.data

import com.google.gson.annotations.SerializedName


data class ItemPoke(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)