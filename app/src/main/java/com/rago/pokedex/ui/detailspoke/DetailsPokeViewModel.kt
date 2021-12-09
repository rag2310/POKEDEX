package com.rago.pokedex.ui.detailspoke

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rago.pokedex.data.Pokemon
import com.rago.pokedex.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsPokeViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    fun getIdPokemon(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonRepository.getPokemonById(getIdUrl(url)).enqueue(object : Callback<Pokemon> {
                override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                    response.body()?.let {
                        _pokemon.postValue(it)
                    }
                }

                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                }

            })
        }
    }

    private fun getIdUrl(url: String): String = url.substring(34).replace('/', ' ').trim()
}
