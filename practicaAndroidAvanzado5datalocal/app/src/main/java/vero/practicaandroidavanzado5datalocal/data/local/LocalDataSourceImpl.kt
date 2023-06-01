package vero.practicaandroidavanzado5datalocal.data.local


import vero.practicaandroidavanzado5datalocal.data.local.model.SuperHeroDetailLocal
import vero.practicaandroidavanzado5datalocal.data.local.model.SuperHeroLocal
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dao: SuperHeroDAO,
    private val preferencesManager: PreferencesManager
) : LocalDataSource {

    override fun getHeros(): List<SuperHeroLocal> {
        return dao.getAllSuperheros()
    }

    override fun insertHeros(remoteSuperHeros: List<SuperHeroLocal>) {
        dao.insertAll(remoteSuperHeros)
    }

    override fun getToken(): String {
        return preferencesManager.getToken()
    }

    override fun setToken(token: String) {
        preferencesManager.setToken(token)
    }

    override fun insertHero(superHeroDetailLocal: SuperHeroDetailLocal) {
        dao.insertSuperheroDetail(superHeroDetailLocal)
    }

    override fun deleteHero(superHeroDetailLocal: SuperHeroDetailLocal) {
        dao.deleteSuperHeroDetail(superHeroDetailLocal)
    }
}
