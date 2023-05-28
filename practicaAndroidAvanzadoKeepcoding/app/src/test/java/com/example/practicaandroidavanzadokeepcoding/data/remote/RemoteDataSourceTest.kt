package com.example.practicaandroidavanzadokeepcoding.data.remote

import com.example.practicaandroidavanzadokeepcoding.data.RemoteDataSource
import com.example.practicaandroidavanzadokeepcoding.data.RemoteDataSource2
import com.example.practicaandroidavanzadokeepcoding.data.remote.request.GetHeroesRequestBody
import com.example.practicaandroidavanzadokeepcoding.data.utils.BaseNetworkMockTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class RemoteDataSourceTest : BaseNetworkMockTest(){
    //UUT O SUT Unit Test o System under Test: siempre va a ser
    //un test unitario por def deberia ser falsear una clase  o el objeto y mockear lo que deependa de ella

    //mocks  cuando hagamos

    @Test
    fun mytest() = runTest{


        //Given : dado un estado

            val remoteDataSource = RemoteDataSource2(api)

        //When : ejecuto algo ()

        val actual = remoteDataSource.getHeroes()

        //then

        assert(actual[0].name == "Broly")

    }

    @Test
    fun `WHEN requesting getHeros EXPECT successful response AND 3 heros starting by B`() = runTest {
        // Given
        val remoteDataSource = RemoteDataSource2(api)

        // When
        val actual = remoteDataSource.getHeroes()

        // Then
        assert(actual.size == 3)
    }
    @Test
    fun myTest3() = runTest {
        // Given
        val getHerosRequestBody = GetHeroesRequestBody("Juan")

        // When

        // Then
        assert(getHerosRequestBody.name == "Juan")
    }




}