package vero.practicaandroidavanzado2.data.local

import vero.practicaandroidavanzado2.data.local.model.LocalSuperhero


interface LocalDataSource {
    suspend fun getHeroes(): List<LocalSuperhero>

    suspend fun insertHero(localSuperhero: LocalSuperhero)

    suspend fun insertHeroes(localSuperheroes: List<LocalSuperhero>)
}
