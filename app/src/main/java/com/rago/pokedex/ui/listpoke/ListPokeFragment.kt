package com.rago.pokedex.ui.listpoke

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rago.pokedex.R
import com.rago.pokedex.data.ItemPoke
import com.rago.pokedex.databinding.FragmentListPokeBinding
import com.rago.pokedex.network.PokeServices
import com.rago.pokedex.network.RetrofitApi
import com.rago.pokedex.repository.ListPokemonRepository

class ListPokeFragment : Fragment() {

    private lateinit var binding: FragmentListPokeBinding

    private lateinit var viewModel: ListPokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_poke, container, false)
        val retrofit = RetrofitApi().getInstance()
        if (retrofit!=null) {
            val pokeServices = retrofit.create(PokeServices::class.java)
            viewModel = ViewModelProvider(
                this, ListPokeViewModelFactory(
                    ListPokemonRepository(pokeServices)
                )
            ).get(ListPokeViewModel::class.java)
        }

        viewModel.getAllPokemon()

        val adapterListPokemon = AdapterListPokemon()
        binding.listPokemon.layoutManager = LinearLayoutManager(requireContext())
        binding.listPokemon.adapter = adapterListPokemon


        viewModel.listPokemon.observe(viewLifecycleOwner, {
            adapterListPokemon.submitList(it)
        })
        return binding.root
    }
}