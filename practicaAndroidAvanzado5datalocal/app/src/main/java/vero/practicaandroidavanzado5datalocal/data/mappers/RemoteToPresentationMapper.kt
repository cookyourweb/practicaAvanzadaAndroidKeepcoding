package vero.practicaandroidavanzado5datalocal.data.mappers


import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroDetailRemote
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroRemote
import vero.practicaandroidavanzado5datalocal.domain.SuperHero
import vero.practicaandroidavanzado5datalocal.domain.SuperHeroDetail
import javax.inject.Inject

class RemoteToPresentationMapper @Inject constructor() {

    fun map(superHeroList: List<SuperHeroRemote>): List<SuperHero> {
        return superHeroList.map { map(it) }
    }

    fun map(superHero: SuperHeroRemote): SuperHero {
        return SuperHero(superHero.id, superHero.name, superHero.photo)
    }

    fun map(superHeroDetailRemote: SuperHeroDetailRemote): SuperHeroDetail {
        return SuperHeroDetail(
            superHeroDetailRemote.id,
            superHeroDetailRemote.name,
            superHeroDetailRemote.photo,
            superHeroDetailRemote.description,
            superHeroDetailRemote.favorite
        )
    }
}
