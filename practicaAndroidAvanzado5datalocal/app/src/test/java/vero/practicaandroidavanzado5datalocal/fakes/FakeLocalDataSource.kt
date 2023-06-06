package vero.practicaandroidavanzado5datalocal.fakes


import vero.practicaandroidavanzado5datalocal.data.local.LocalDataSource
import vero.practicaandroidavanzado5datalocal.data.local.model.SuperHeroDetailLocal
import vero.practicaandroidavanzado5datalocal.data.local.model.SuperHeroLocal
import vero.practicaandroidavanzado5datalocal.utils.generateHerosLocal

class FakeLocalDataSource: LocalDataSource {
    private var firstCall = true

    override fun getHeros(): List<SuperHeroLocal> {
        return if (firstCall){
            firstCall = false
            emptyList()
        } else {
            generateHerosLocal()
        }
    }

    override fun insertHeros(remoteSuperHeros: List<SuperHeroLocal>) {

    }

    override fun getToken(): String {
        TODO("Not yet implemented")
    }

    override fun setToken(token: String) {
        TODO("Not yet implemented")
    }

    override fun insertHero(superHeroDetailLocal: SuperHeroDetailLocal) {
        TODO("Not yet implemented")
    }

    override fun deleteHero(superHeroDetailLocal: SuperHeroDetailLocal) {
        TODO("Not yet implemented")
    }
}
