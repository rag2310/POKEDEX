package com.rago.pokedex.repository

import com.rago.pokedex.network.PokeServices

class PokemonRepository(private val pokeServices: PokeServices) {
    fun getPokemonById(idPoke:String) = pokeServices.getPokemon(idPoke)
}