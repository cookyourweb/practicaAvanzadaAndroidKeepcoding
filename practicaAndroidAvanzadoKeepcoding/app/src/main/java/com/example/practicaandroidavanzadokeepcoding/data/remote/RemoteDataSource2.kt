package com.example.practicaandroidavanzadokeepcoding.data

import com.example.practicaandroidavanzadokeepcoding.data.remote.GetHeroesResponse
import com.example.practicaandroidavanzadokeepcoding.data.remote.request.GetHeroesRequestBody

class RemoteDataSource2(private val api: DragonBallApi) {
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