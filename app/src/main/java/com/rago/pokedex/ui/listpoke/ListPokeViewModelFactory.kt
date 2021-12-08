package com.rago.pokedex.ui.listpoke

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rago.pokedex.repository.ListPokemonRepository

class ListPokeViewModelFactory constructor(private val listPokemonRepository: ListPokemonRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ListPokeViewModel::class.java)) {
            ListPokeViewModel(listPokemonRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}