package vero.practicaandroidavanzadoreentrega.data.remote

import vero.practicaandroidavanzadoreentrega.data.remote.request.FavouriteRequest
import vero.practicaandroidavanzadoreentrega.data.remote.request.HerosRequest
import vero.practicaandroidavanzadoreentrega.data.remote.request.LocationsRequest
import vero.practicaandroidavanzadoreentrega.data.remote.response.SuperHeroDetailRemote
import vero.practicaandroidavanzadoreentrega.data.remote.response.SuperHeroLocationRemote
import vero.practicaandroidavanzadoreentrega.data.remote.response.SuperHeroRemote
import vero.practicaandroidavanzadoreentrega.domain.Bootcamp
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface DragonBallAPI {

    @GET("api/data/bootcamps")
    suspend fun getBootcamps(): List<Bootcamp>

    @POST("api/heros/all")
    suspend fun getHerosWithException(): List<SuperHeroRemote>

    @POST("api/heros/all")
    suspend fun getHeros(@Body herosRequest: HerosRequest): List<SuperHeroRemote>

    @POST("api/heros/all")
    suspend fun getHeroDetail(@Body herosRequest: HerosRequest): List<SuperHeroDetailRemote>

    @POST("api/auth/login")
    suspend fun login(@Header("Authorization") basicAuth: String): String

    @POST("api/data/herolike")
    suspend fun toggleFavourite(@Body favouriteRequest: FavouriteRequest)

    @POST("api/heros/locations")
    suspend fun getHeroLocations(@Body locationsRequest: LocationsRequest): List<SuperHeroLocationRemote>
}
