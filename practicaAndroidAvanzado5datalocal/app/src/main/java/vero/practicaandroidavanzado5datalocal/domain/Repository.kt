package vero.practicaandroidavanzado5datalocal.domain

import com.google.android.gms.maps.model.LatLng
import vero.practicaandroidavanzado5datalocal.ui.superherolist.SuperHeroListState


interface Repository {
    suspend fun getBootcamps(): List<Bootcamp>
    suspend fun getHeros(): List<SuperHero>
    suspend fun getHerosWithCache(): List<SuperHero>
    suspend fun getHerosWithException(): SuperHeroListState
    suspend fun getHeroDetail(name: String): SuperHeroDetail?
    suspend fun login(email: String, password: String): Boolean

    suspend fun insertFav(superHeroDetail: SuperHeroDetail)
    suspend fun deleteFav(superHeroDetail: SuperHeroDetail)
    suspend fun getHeroLocations(id: String): List<LatLng>
}
