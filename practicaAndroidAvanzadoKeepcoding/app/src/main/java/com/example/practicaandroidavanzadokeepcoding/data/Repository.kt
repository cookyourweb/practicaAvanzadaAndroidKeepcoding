package com.example.practicaandroidavanzadokeepcoding.data

import com.example.practicaandroidavanzadokeepcoding.data.remote.GetHeroesResponse
import com.example.practicaandroidavanzadokeepcoding.data.remote.request.GetHeroesRequestBody

class Repository {
    private val remoteDataSource = RemoteDataSource()
    suspend fun getHeroes(): List<GetHeroesResponse>{
        return  remoteDataSource.getHeroes()
    }

}

