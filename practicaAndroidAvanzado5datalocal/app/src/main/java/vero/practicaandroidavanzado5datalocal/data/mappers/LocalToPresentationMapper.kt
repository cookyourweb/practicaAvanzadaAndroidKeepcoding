package vero.practicaandroidavanzado5datalocal.data.mappers


import vero.practicaandroidavanzado5datalocal.data.local.model.SuperHeroLocal
import vero.practicaandroidavanzado5datalocal.domain.SuperHero
import javax.inject.Inject

class LocalToPresentationMapper @Inject constructor() {

    fun map(superHeroList: List<SuperHeroLocal>): List<SuperHero> {
        return superHeroList.map { map(it) }
    }

    fun map(superHero: SuperHeroLocal): SuperHero {
        return SuperHero(superHero.id, superHero.name, superHero.photo)
    }

}
