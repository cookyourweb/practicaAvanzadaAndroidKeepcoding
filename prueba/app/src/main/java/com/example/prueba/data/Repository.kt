package com.example.practicaandroidavanzadokeepcoding.data

import com.example.practicaandroidavanzadokeepcoding.data.remote.response.GetHeroesResponse
import com.example.practicaandroidavanzadokeepcoding.data.remote.RemoteDataSource

class Repository {
    private val remoteDataSource = RemoteDataSource()

    suspend fun getHeroes(): List<GetHeroesResponse>{
        return remoteDataSource.getHeroes()
    }
}