package com.rago.pokedex.data

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("official-artwork")
    var official:OfficialArtwork
)
