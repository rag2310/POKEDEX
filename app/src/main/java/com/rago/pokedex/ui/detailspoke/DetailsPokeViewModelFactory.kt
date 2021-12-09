package com.rago.pokedex.ui.detailspoke

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rago.pokedex.repository.PokemonRepository

class DetailsPokeViewModelFactory constructor(private val pokemonRepository: PokemonRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DetailsPokeViewModel::class.java)) {
            DetailsPokeViewModel(pokemonRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}