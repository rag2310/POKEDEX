package com.rago.pokedex.ui.detailspoke

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.rago.pokedex.R
import com.rago.pokedex.databinding.FragmentDetailsPokeBinding
import com.rago.pokedex.network.PokeServices
import com.rago.pokedex.network.RetrofitApi
import com.rago.pokedex.repository.PokemonRepository
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class DetailsPokeFragment : Fragment() {

    private val args: DetailsPokeFragmentArgs by navArgs()

    private lateinit var binding: FragmentDetailsPokeBinding
    private lateinit var viewModel: DetailsPokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_details_poke, container, false)
        val retrofit = RetrofitApi().getInstance()
        if (retrofit != null) {
            val pokeServices = retrofit.create(PokeServices::class.java)
            viewModel = ViewModelProvider(
                this, DetailsPokeViewModelFactory(
                    PokemonRepository(pokeServices)
                )
            ).get(DetailsPokeViewModel::class.java)
            viewModel.getIdPokemon(args.url)
            val adapterListAbilities = AdapterListAbilities()
            binding.abilitiesRv.layoutManager = LinearLayoutManager(requireContext())
            binding.abilitiesRv.adapter = adapterListAbilities

            viewModel.pokemon.observe(viewLifecycleOwner, {
                binding.detailsPokemon = it
                binding.idPoke = it.getId()
                Picasso.get().load(it.sprites.other.official.frontDefault).resize(200, 200)
                    .into(binding.pokemonIv)
                adapterListAbilities.submitList(it.abilities)
                isLoading()
            })
        }
        return binding.root
    }

    private fun isLoading() {
        binding.id.visibility = View.VISIBLE
        binding.name.visibility = View.VISIBLE
        binding.pokemonIv.visibility = View.VISIBLE
        binding.ability.visibility = View.VISIBLE
        binding.abilitiesRv.visibility = View.VISIBLE
        binding.loading.visibility = View.GONE

    }
}