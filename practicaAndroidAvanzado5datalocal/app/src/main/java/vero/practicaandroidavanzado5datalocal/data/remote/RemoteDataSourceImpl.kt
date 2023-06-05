package vero.practicaandroidavanzado5datalocal.data.remote

import android.util.Log
import com.google.android.gms.maps.model.LatLng

import okhttp3.Credentials
import vero.practicaAndroidAvanzadov5.data.remote.DragonBallAPI
import vero.practicaandroidavanzado5datalocal.data.remote.request.FavouriteRequest
import vero.practicaandroidavanzado5datalocal.data.remote.request.GetHeroesRequestBody
import vero.practicaandroidavanzado5datalocal.data.remote.request.GetLocationRequestBody
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroDetailRemote
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroRemote

import vero.practicaandroidavanzado5datalocal.domain.Bootcamp
import javax.inject.Inject


class RemoteDataSourceImpl @Inject constructor(private val api: DragonBallAPI) : RemoteDataSource {

    override suspend fun getBootcamps(): List<Bootcamp> {
        Log.d( "bootcamps" , "petición bootcamp")
        return api.getBootcamps()
    }

    override suspend fun getHeros(): List<SuperHeroRemote> {
        return api.getHeros(GetHeroesRequestBody())
    }

    override suspend fun getHerosWithException(): Result<List<SuperHeroRemote>> {
        return runCatching { api.getHerosWithException() }
    }

    override suspend fun getHeroDetail(name: String): Result<SuperHeroDetailRemote?> {
        return runCatching { api.getHeroDetail(GetHeroesRequestBody(name)).firstOrNull() }
    }

    override suspend fun login(email: String, password: String): Result<String> {
        return runCatching { api.login(Credentials.basic(email, password)) }
    }

    override suspend fun toggleFavourite(id: String) {
        api.toggleFavourite(FavouriteRequest(id))
    }

    override suspend fun getSuperheroLocations(id: String): List<LatLng> {
        return api.getHeroLocations(GetLocationRequestBody(id))
            .map { LatLng(it.latitud.toDouble(), it.longitud.toDouble()) }
    }


}
