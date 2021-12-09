package com.rago.pokedex.ui.listpoke

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rago.pokedex.data.ItemPoke
import com.rago.pokedex.databinding.ItemPokemonBinding

class AdapterListPokemon :
    ListAdapter<ItemPoke, AdapterListPokemon.ItemPokeViewHolder>(PokemonComparator()) {


    open class ItemPokeViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemPoke) {
            binding.pokemon = item
            binding.cardDetails.setOnClickListener {
                it.findNavController()
                    .navigate(
                        ListPokeFragmentDirections.actionListPokeFragmentToDetailsPokeFragment(
                            item.url
                        )
                    )
            }
        }

        companion object {
            fun create(parent: ViewGroup): ItemPokeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: ItemPokemonBinding = ItemPokemonBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
                return ItemPokeViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPokeViewHolder {
        return ItemPokeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemPokeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PokemonComparator() : DiffUtil.ItemCallback<ItemPoke>() {
    override fun areItemsTheSame(oldItem: ItemPoke, newItem: ItemPoke): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: ItemPoke, newItem: ItemPoke): Boolean {
        return oldItem == newItem
    }

}