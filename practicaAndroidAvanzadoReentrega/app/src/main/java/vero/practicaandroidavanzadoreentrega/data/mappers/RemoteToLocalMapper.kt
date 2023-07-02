package vero.practicaandroidavanzadoreentrega.data.mappers

import vero.practicaandroidavanzadoreentrega.data.local.model.SuperHeroDetailLocal
import vero.practicaandroidavanzadoreentrega.data.local.model.SuperHeroLocal
import vero.practicaandroidavanzadoreentrega.data.remote.response.SuperHeroDetailRemote
import vero.practicaandroidavanzadoreentrega.data.remote.response.SuperHeroRemote
import vero.practicaandroidavanzadoreentrega.domain.SuperHeroDetail
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
