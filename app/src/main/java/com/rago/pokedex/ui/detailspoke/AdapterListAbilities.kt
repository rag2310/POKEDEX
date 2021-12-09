package com.rago.pokedex.ui.detailspoke

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rago.pokedex.data.Abilities
import com.rago.pokedex.data.ItemPoke
import com.rago.pokedex.databinding.ItemAbilityBinding
import com.rago.pokedex.databinding.ItemPokemonBinding
import com.rago.pokedex.ui.listpoke.ListPokeFragmentDirections

class AdapterListAbilities : ListAdapter<Abilities, AdapterListAbilities.AbilitiesViewHolder>(
    AbilitiesViewHolder()
) {

    open class AbilitiesViewHolder(private val binding: ItemAbilityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Abilities) {
            binding.ability = item.ability
        }

        companion object {
            fun create(parent: ViewGroup): AbilitiesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: ItemAbilityBinding = ItemAbilityBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
                return AbilitiesViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitiesViewHolder {
        return AbilitiesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AbilitiesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class AbilitiesViewHolder() : DiffUtil.ItemCallback<Abilities>() {
    override fun areItemsTheSame(oldItem: Abilities, newItem: Abilities): Boolean {
        return oldItem.ability.name == newItem.ability.name
    }

    override fun areContentsTheSame(oldItem: Abilities, newItem: Abilities): Boolean {
        return oldItem == newItem
    }


}