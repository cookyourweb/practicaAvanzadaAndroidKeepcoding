package vero.practicaandroidavanzadoreentrega.data.mappers

import vero.practicaandroidavanzadoreentrega.data.local.model.SuperHeroDetailLocal
import vero.practicaandroidavanzadoreentrega.domain.SuperHeroDetail
import javax.inject.Inject

class PresentationToLocalMapper @Inject constructor() {

    fun map(superHeroList: List<SuperHeroDetail>): List<SuperHeroDetailLocal> {
        return superHeroList.map { map(it) }
    }

    fun map(superHeroDetail: SuperHeroDetail): SuperHeroDetailLocal {
        return SuperHeroDetailLocal(
            superHeroDetail.id,
            superHeroDetail.name,
            superHeroDetail.photo,
            superHeroDetail.description
        )
    }

}
