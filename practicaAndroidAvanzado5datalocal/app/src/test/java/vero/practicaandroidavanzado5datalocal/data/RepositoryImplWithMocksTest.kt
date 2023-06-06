package vero.practicaandroidavanzado5datalocal.data

import com.google.common.truth.Truth

import io.mockk.coEvery
import io.mockk.coVerify
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
import vero.practicaandroidavanzado5datalocal.data.remote.RemoteDataSource
import vero.practicaandroidavanzado5datalocal.fakes.FakeLocalDataSource
import vero.practicaandroidavanzado5datalocal.utils.generateBootcamps
import vero.practicaandroidavanzado5datalocal.utils.generateHeros
import vero.practicaandroidavanzado5datalocal.utils.generateHerosRemote

@OptIn(ExperimentalCoroutinesApi::class)
class RepositoryImplWithMocksTest {

    //UUT o SUT
    private lateinit var repositoryImpl: RepositoryImpl
    private lateinit var localDataSource: LocalDataSource
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setUp(){
        localDataSource = mockk()
        remoteDataSource = mockk()

        repositoryImpl = RepositoryImpl(
            localDataSource,
            remoteDataSource,
            RemoteToPresentationMapper(),
            RemoteToLocalMapper(),
            LocalToPresentationMapper(),
            PresentationToLocalMapper()
        )
    }

    @Test
    fun `WHEN getBootcamps THEN SUCCESS not empty list`() = runTest {
        // GIVEN
        coEvery { remoteDataSource.getBootcamps() } returns generateBootcamps()

        // WHEN
        val actual = repositoryImpl.getBootcamps()

        // THEN
        // Version JUnit
        assert(actual.isNotEmpty())
        assertEquals(actual[0].name, "Name 0")

        // Version Truth
        Truth.assertThat(actual).isNotEmpty()
        Truth.assertThat(actual.first().name).isEqualTo("Name 0")
        Truth.assertThat(actual).containsExactlyElementsIn(generateBootcamps())
    }

    @Test
    fun `WHEN getHeros THEN SUCCESS return list from local and remote called`() = runTest {
        // GIVEN
        coEvery { localDataSource.getHeros() } returns emptyList()
        coEvery { localDataSource.insertHeros(any()) } returns Unit
        coEvery { remoteDataSource.getHeros() } returns generateHerosRemote()

        // WHEN
        val actual = repositoryImpl.getHerosWithCache()

        // THEN
        coVerify { remoteDataSource.getHeros() }
        coVerify(exactly = 2) { localDataSource.getHeros() }
    }

    @Test
    fun `WHEN getHeros THEN SUCCESS return list from local and remote called with FAKE`() = runTest {
        // GIVEN
        val localDataSource = FakeLocalDataSource()
        repositoryImpl = RepositoryImpl(
            localDataSource,
            remoteDataSource,
            RemoteToPresentationMapper(),
            RemoteToLocalMapper(),
            LocalToPresentationMapper(),
            PresentationToLocalMapper()
        )

        coEvery { remoteDataSource.getHeros() } returns generateHerosRemote()

        // WHEN
        val actual = repositoryImpl.getHerosWithCache()

        // THEN
        Truth.assertThat(actual).isNotEmpty()
        Truth.assertThat(actual.first().name).isEqualTo("Name 0")
        coVerify { remoteDataSource.getHeros() }
        Truth.assertThat(actual).containsExactlyElementsIn(generateHeros())
    }
}
