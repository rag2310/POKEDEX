package com.rago.pokedex.data

import com.google.gson.annotations.SerializedName

data class Sprites(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("other")
    var other: Other
)