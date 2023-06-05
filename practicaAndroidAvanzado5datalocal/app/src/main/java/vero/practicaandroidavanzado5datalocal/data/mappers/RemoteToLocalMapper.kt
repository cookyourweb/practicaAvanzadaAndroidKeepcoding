package vero.practicaandroidavanzado5datalocal.data.mappers


import vero.practicaandroidavanzado5datalocal.data.local.model.SuperHeroDetailLocal
import vero.practicaandroidavanzado5datalocal.data.local.model.SuperHeroLocal
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroDetailRemote
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroRemote
import javax.inject.Inject

class RemoteToLocalMapper @Inject constructor() {

    fun map(superHeroRemoteList: List<SuperHeroRemote>): List<SuperHeroLocal> {
        return superHeroRemoteList.map { map(it) }
    }

    fun map(superHeroRemote: SuperHeroRemote): SuperHeroLocal {
        return SuperHeroLocal(
            superHeroRemote.id,
            superHeroRemote.name,
            superHeroRemote.photo,
            superHeroRemote.description,
            false
        )
    }

    fun map(superHeroDetailRemote: SuperHeroDetailRemote): SuperHeroDetailLocal {
        return SuperHeroDetailLocal(
            superHeroDetailRemote.id,
            superHeroDetailRemote.name,
            superHeroDetailRemote.photo,
            superHeroDetailRemote.description
        )
    }

}
