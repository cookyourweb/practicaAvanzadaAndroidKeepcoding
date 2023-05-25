package com.example.practicaandroidavanzadokeepcoding.data

import com.example.practicaandroidavanzadokeepcoding.data.remote.GetHeroesResponse



class Repository {
    private val remoteDataSource = RemoteDataSource3()
    suspend fun getHeroes(): List<GetHeroesResponse>{


        return  remoteDataSource.getHeroes()
    }

}

