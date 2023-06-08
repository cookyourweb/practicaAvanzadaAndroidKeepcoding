 package vero.practicaandroidavanzado5datalocal.fakes

import com.google.android.gms.maps.model.LatLng

import retrofit2.HttpException
import retrofit2.Response
import vero.practicaandroidavanzado5datalocal.data.remote.RemoteDataSource
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroDetailRemote
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroRemote

 class FakeRemoteDataSource : RemoteDataSource {

    override suspend fun getHeros(): List<SuperHeroRemote> {
        TODO("Not yet implemented")
    }

    override suspend fun getHerosWithException(): Result<List<SuperHeroRemote>> {
        TODO("Not yet implemented")
    }

    override suspend fun getHeroDetail(name: String): Result<SuperHeroDetailRemote?> {
        return when (name) {
            "SUCCESS" -> Result.success(
                SuperHeroDetailRemote(
                    "id",
                    "Maestro Roshi",
                    "photo",
                    "description",
                    false
                )
            )
            "NETWORK_ERROR" -> Result.failure(HttpException(Response.success(204, {})))
            "NULL" -> Result.failure(NullPointerException("Null pointer error"))
            "SUCCESS_BUT_NULL" -> Result.success(null)
            else -> {
                Result.failure(Exception())
            }
        }
    }

    override suspend fun login(email: String, password: String): Result<String> {
        TODO("Not yet implemented")
    }

    override suspend fun toggleFavourite(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getSuperheroLocations(id: String): List<LatLng> {
        TODO("Not yet implemented")
    }
}
