package com.rago.pokedex.ui.listpoke

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rago.pokedex.data.CustomJson
import com.rago.pokedex.data.ItemPoke
import com.rago.pokedex.repository.ListPokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPokeViewModel(private val listPokemonRepository: ListPokemonRepository) : ViewModel() {

    private var _listPokemon = MutableLiveData<List<ItemPoke>>()
    val listPokemon: LiveData<List<ItemPoke>> = _listPokemon

    fun getAllPokemon() {

        viewModelScope.launch(Dispatchers.IO) {
            listPokemonRepository.getAllPokemon().enqueue(object : Callback<CustomJson> {
                override fun onResponse(call: Call<CustomJson>, response: Response<CustomJson>) {
                    response.body()?.let {
                        _listPokemon.postValue(it.results)
                    }
                }

                override fun onFailure(call: Call<CustomJson>, t: Throwable) {
                    println("Error")
                }

            })
        }
    }

}