package vero.practicaandroidavanzado2.data.remote

import vero.practicaandroidavanzado2.data.remote.response.GetHeroesResponse
import vero.practicaandroidavanzado2.data.remote.request.GetHeroesRequestBody
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: DragonBallApi){

    suspend fun getHeroes(): List<GetHeroesResponse> {
        return api.getHeroes(GetHeroesRequestBody())

    }

    /*

 //Este codigo se extrae como dependencias, lo que hace qu la clase sea mucho mas facil testearla
//antes nuestra clase pasaba si o si por pedir a prod  el json y ejecutarse en un emulador.
//Con el cambio de sacar las depencias, podemos
//ejecutarlo en un test unitario y mockear la respuesta

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val okHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {

                level = HttpLoggingInterceptor.Level.BODY
            }).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dragonball.keepcoding.education/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    //es una abstraccion(es un interfaz que por def es una abstraccion pq no tiene implementacion. El que le da la implementacion es el retrofit)
    private val api: DragonBallApi = retrofit.create(DragonBallApi::class.java)
*/



}

