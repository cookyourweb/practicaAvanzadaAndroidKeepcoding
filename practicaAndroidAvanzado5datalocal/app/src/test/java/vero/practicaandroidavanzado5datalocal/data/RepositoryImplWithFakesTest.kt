package vero.practicaandroidavanzado5datalocal.data


import com.google.common.truth.Truth
import vero.practicaandroidavanzado5datalocal.fakes.FakeRemoteDataSource
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import vero.practicaandroidavanzado5datalocal.data.local.LocalDataSource
import vero.practicaandroidavanzado5datalocal.data.mappers.LocalToPresentationMapper
import vero.practicaandroidavanzado5datalocal.data.mappers.PresentationToLocalMapper
import vero.practicaandroidavanzado5datalocal.data.mappers.RemoteToLocalMapper
import vero.practicaandroidavanzado5datalocal.data.mappers.RemoteToPresentationMapper

@OptIn(ExperimentalCoroutinesApi::class)
class RepositoryImplWithFakesTest {

    //UUT o SUT
    private lateinit var repositoryImplSUT: RepositoryImpl
    private lateinit var localDataSourceSUT: LocalDataSource
    private val fakeRemoteDataSourceSUT = FakeRemoteDataSource()

    @Before
    fun setUpMocks(){

        localDataSourceSUT = mockk()

        repositoryImplSUT = RepositoryImpl(
            localDataSourceSUT,
            fakeRemoteDataSourceSUT,
            RemoteToPresentationMapper(),
            RemoteToLocalMapper(),
            LocalToPresentationMapper(),
            PresentationToLocalMapper()
        )
    }


    @Test
    fun `WHEN getHeroDetail EXPECT failure with generic error`() = runTest {
        // GIVEN

        // WHEN
        val actual = repositoryImplSUT.getHeroDetail("NULL")

        // THEN
        Truth.assertThat(actual).isNull()
    }

    @Test
    fun `WHEN getHeroDetail EXPECT failure with generic error in success call`() = runTest {
        // GIVEN

        // WHEN
        val actual = repositoryImplSUT.getHeroDetail("SUCCESS_BUT_NULL")

        // THEN
        Truth.assertThat(actual).isNull()
    }

    @Test
    fun `WHEN getHeroDetail EXPECT failure with network error`() = runTest {
        // GIVEN

        // WHEN
        val actual = repositoryImplSUT.getHeroDetail("NETWORK_ERROR")

        // THEN
        Truth.assertThat(actual).isNull()
    }

}
