package com.example.practicaandroidavanzadokeepcoding.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaandroidavanzadokeepcoding.R

class SuperHeroAdapter:  RecyclerView.Adapter<SuperHeroAdapter.SuperHeroViewHolder>() {


val superheros = listOf(
    "hero 1",
    "hero 2",
    "hero 3",
    "hero 4",
    "hero 5",
    "hero 6",
    "hero 7",
    "hero 8",
    "hero 9",
    "hero 10",
)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
     //crea la celda
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero,parent, false)
        return SuperHeroViewHolder(view)

    }

    override fun getItemCount(): Int {
        return superheros.size
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
      holder.bind(superheros[position])
    }


    class SuperHeroViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        val superheroName  = itemView.findViewById<TextView>(R.id.superhero_name)
        fun bind(superhero:String){
            superheroName.text=superhero
        }

    }
}