package vero.practicaandroidavanzado5datalocal.data.remote
import com.google.android.gms.maps.model.LatLng
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroDetailRemote
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroRemote
import vero.practicaandroidavanzado5datalocal.domain.Bootcamp


interface RemoteDataSource {
    suspend fun getBootcamps(): List<Bootcamp>
    suspend fun getHeros(): List<SuperHeroRemote>
    suspend fun getHerosWithException(): Result<List<SuperHeroRemote>>
    suspend fun getHeroDetail(name: String): Result<SuperHeroDetailRemote?>
    suspend fun login(email: String, password: String): Result<String>
    suspend fun toggleFavourite(id: String)
    suspend fun getSuperheroLocations(id: String): List<LatLng>
}
