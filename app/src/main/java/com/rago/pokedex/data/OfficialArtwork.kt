package com.rago.pokedex.data

import com.google.gson.annotations.SerializedName

data class OfficialArtwork (
    @SerializedName("front_default")
    var frontDefault:String
)