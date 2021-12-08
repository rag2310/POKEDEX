package com.rago.pokedex.data

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("abilities")
    var abilities: List<Abilities>,
    @SerializedName("name")
    var name: String,
    @SerializedName("sprites")
    var sprites: Sprites
)
