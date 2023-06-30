package vero.practicaandroidavanzado2.data.mappers

import vero.practicaandroidavanzado2.data.local.model.LocalSuperhero
import vero.practicaandroidavanzado2.ui.model.Superhero
import javax.inject.Inject

class LocalToPresentationMapper @Inject constructor() {

    fun mapLocalSuperheroes(localSuperheroes: List<LocalSuperhero>): List<Superhero> {
        return localSuperheroes.map { mapLocalSuperheroes(it) }
    }

    fun mapLocalSuperheroes(getHeroesResponse: LocalSuperhero): Superhero {
        return Superhero(getHeroesResponse.id, getHeroesResponse.name)
    }
}
