package vero.practicaandroidavanzadoreentrega.data.remote

import com.google.android.gms.maps.model.LatLng
import vero.practicaandroidavanzadoreentrega.data.remote.request.FavouriteRequest
import vero.practicaandroidavanzadoreentrega.data.remote.request.HerosRequest
import vero.practicaandroidavanzadoreentrega.data.remote.request.LocationsRequest
import vero.practicaandroidavanzadoreentrega.data.remote.response.SuperHeroDetailRemote
import vero.practicaandroidavanzadoreentrega.data.remote.response.SuperHeroRemote
import vero.practicaandroidavanzadoreentrega.domain.Bootcamp
import okhttp3.Credentials
import javax.inject.Inject


class RemoteDataSourceImpl @Inject constructor(private val api: DragonBallAPI) : RemoteDataSource {

    override suspend fun getBootcamps(): List<Bootcamp> {
        return api.getBootcamps()
    }

    override suspend fun getHeros(): List<SuperHeroRemote> {
        return api.getHeros(HerosRequest())
    }

    override suspend fun getHerosWithException(): Result<List<SuperHeroRemote>> {
        return runCatching { api.getHerosWithException() }
    }

    override suspend fun getHeroDetail(name: String): Result<SuperHeroDetailRemote?> {
        return runCatching { api.getHeroDetail(HerosRequest(name)).firstOrNull() }
    }

    override suspend fun login(email: String, password: String): Result<String> {
        return runCatching { api.login(Credentials.basic(email, password)) }
    }

    override suspend fun toggleFavourite(id: String) {
        api.toggleFavourite(FavouriteRequest(id))
    }

    override suspend fun getSuperheroLocations(id: String): List<LatLng> {
        return api.getHeroLocations(LocationsRequest(id))
            .map { LatLng(it.latitud.toDouble(), it.longitud.toDouble()) }
    }


}
