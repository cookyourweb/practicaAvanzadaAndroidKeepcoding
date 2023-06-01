package vero.practicaandroidavanzado5datalocal.data.local
import vero.practicaandroidavanzado5datalocal.data.local.model.SuperHeroDetailLocal
import vero.practicaandroidavanzado5datalocal.data.local.model.SuperHeroLocal


interface LocalDataSource {
    fun getHeros(): List<SuperHeroLocal>
    fun insertHeros(remoteSuperHeros: List<SuperHeroLocal>)
    fun getToken(): String
    fun setToken(token: String)
    fun insertHero(superHeroDetailLocal: SuperHeroDetailLocal)
    fun deleteHero(superHeroDetailLocal: SuperHeroDetailLocal)
}
