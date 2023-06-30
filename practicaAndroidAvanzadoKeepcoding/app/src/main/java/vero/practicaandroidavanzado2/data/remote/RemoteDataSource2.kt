package vero.practicaandroidavanzado2.data.remote

import vero.practicaandroidavanzado2.data.remote.request.GetHeroesRequestBody
import vero.practicaandroidavanzado2.data.remote.response.GetHeroesResponse


class RemoteDataSource2 (private val api: DragonBallApi) {
//Declaro la dependencia para que alguien me la pase


    suspend fun getHeroes(): List<GetHeroesResponse>{

        val result = api.getHeroes(GetHeroesRequestBody())
        val newList = result.filter { it.name.startsWith("B") }
//este  codigo devuelve el resultado
        return  api.getHeroes(GetHeroesRequestBody())
        return newList

        //
    }

}