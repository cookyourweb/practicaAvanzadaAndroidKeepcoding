package vero.practicaandroidavanzado5datalocal.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kotlinx.coroutines.NonDisposableHandle.parent
import vero.practicaandroidavanzado5datalocal.R
import vero.practicaandroidavanzado5datalocal.databinding.ItemListBinding
import vero.practicaandroidavanzado5datalocal.domain.SuperHero

/*
*
* An Adapter object acts as a bridge between an AdapterView
* and the underlying data for that view.
* The Adapter provides access to the data items.
*  The Adapter is also responsible for making a android.view.View
* for each item in the data set.
*
*
* */


    class SuperHeroListAdapter(private val clickListener: (SuperHero) -> (Unit)) :
        ListAdapter<SuperHero, SuperHeroListAdapter.SuperHeroViewHolder>(SuperHeroDiffCallback()) {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            val binding = ItemListBinding.bind(view)
            return SuperHeroViewHolder(binding)
        }

        override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
            holder.bind(getItem(position))
        }

        inner class SuperHeroViewHolder(private val binding: ItemListBinding) :
            RecyclerView.ViewHolder(binding.root) {

            private lateinit var superHero: SuperHero

            init {
                binding.root.setOnClickListener {
                    clickListener(superHero)
                }
            }

            fun bind(superHero: SuperHero) {
                this.superHero = superHero

                with(binding) {
                    superheroName.text = superHero.name
                    superheroImage.load(superHero.photo)
                }
            }
        }

        class SuperHeroDiffCallback : DiffUtil.ItemCallback<SuperHero>() {
            override fun areItemsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
                return oldItem == newItem
            }

        }
    }

