package vero.practicaAndroidAvanzadov5.data.remote


import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import vero.practicaandroidavanzado5datalocal.data.remote.request.FavouriteRequest
import vero.practicaandroidavanzado5datalocal.data.remote.request.GetHeroesRequestBody
import vero.practicaandroidavanzado5datalocal.data.remote.request.GetLocationRequestBody
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroDetailRemote
import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroLocationRemote

import vero.practicaandroidavanzado5datalocal.data.remote.response.SuperHeroRemote
import vero.practicaandroidavanzado5datalocal.domain.Bootcamp
//las interfaces por def son abstracciones pq no tienen implementacion
interface DragonBallAPI {

    @GET("api/data/bootcamps")
    suspend fun getBootcamps(): List<Bootcamp>

    @POST("api/heros/all")
    suspend fun getHerosWithException(): List<SuperHeroRemote>

    @POST("api/heros/all")
    suspend fun getHeros(@Body herosRequest: GetHeroesRequestBody): List<SuperHeroRemote>

    @POST("api/heros/all")
    suspend fun getHeroDetail(@Body herosRequest: GetHeroesRequestBody): List<SuperHeroDetailRemote>

    @POST("api/auth/login")
    suspend fun login(@Header("Authorization") basicAuth: String): String

    @POST("api/data/herolike")
    suspend fun toggleFavourite(@Body favouriteRequest: FavouriteRequest)

    @POST("api/heros/locations")
    suspend fun getHeroLocations(@Body getLocationRequestBody: GetLocationRequestBody): List<SuperHeroLocationRemote>
}
