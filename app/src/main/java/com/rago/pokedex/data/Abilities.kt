package com.rago.pokedex.data

import com.google.gson.annotations.SerializedName

data class Abilities(
    @SerializedName("ability")
    var ability: Ability,
    @SerializedName("is_hidden")
    var isHidden: Boolean,
    @SerializedName("slot")
    var slot: Int
)