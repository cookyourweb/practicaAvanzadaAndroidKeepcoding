package vero.practicaandroidavanzadoreentrega.data.local

import vero.practicaandroidavanzadoreentrega.data.local.model.SuperHeroDetailLocal
import vero.practicaandroidavanzadoreentrega.data.local.model.SuperHeroLocal

interface LocalDataSource {
    fun getHeros(): List<SuperHeroLocal>
    fun insertHeros(remoteSuperHeros: List<SuperHeroLocal>)
    fun getToken(): String
    fun setToken(token: String)
    fun insertHero(superHeroDetailLocal: SuperHeroDetailLocal)
    fun deleteHero(superHeroDetailLocal: SuperHeroDetailLocal)
}
