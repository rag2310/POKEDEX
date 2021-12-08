package com.rago.pokedex.repository

import com.rago.pokedex.network.PokeServices

class ListPokemonRepository(private val pokeServices: PokeServices) {
    fun getAllPokemon() = pokeServices.listRepos()
}