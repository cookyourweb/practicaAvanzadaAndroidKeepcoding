package vero.practicaandroidavanzadoreentrega.data.mappers

import vero.practicaandroidavanzadoreentrega.data.local.model.SuperHeroLocal
import vero.practicaandroidavanzadoreentrega.domain.SuperHero
import javax.inject.Inject

class LocalToPresentationMapper @Inject constructor() {

    fun map(superHeroList: List<SuperHeroLocal>): List<SuperHero> {
        return superHeroList.map { map(it) }
    }

    fun map(superHero: SuperHeroLocal): SuperHero {
        return SuperHero(superHero.id, superHero.name, superHero.photo)
    }

}
