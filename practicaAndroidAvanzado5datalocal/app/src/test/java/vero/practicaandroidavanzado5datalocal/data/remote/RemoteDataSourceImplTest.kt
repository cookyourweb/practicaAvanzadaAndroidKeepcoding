package vero.practicaandroidavanzado5datalocal.data.remote

import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import practicaandroidavanzado5datalocal.base.BaseNetworkTest

@OptIn(ExperimentalCoroutinesApi::class)
class RemoteDataSourceImplTest : BaseNetworkTest(){

    // SUT o UUT
    private lateinit var remoteDataSourceImpl: RemoteDataSourceImpl


    @Test
    fun `WHEN getHeros EXPECT sucesss and returns hero list`() = runTest {
        // GIVEN
        remoteDataSourceImpl = RemoteDataSourceImpl(api)

        // WHEN
        val actual = remoteDataSourceImpl.getHeros()

        // THEN
        Truth.assertThat(actual).hasSize(15)
        Truth.assertThat(actual[0].name).isEqualTo("Maestro Roshi")
    }

}