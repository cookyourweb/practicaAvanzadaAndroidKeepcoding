package com.example.practicaandroidavanzadokeepcoding.data

import  retrofit2.http.POST;

interface DragonBallApi {

    @POST("api/heros/all")
    suspend fun getHeros()
}
