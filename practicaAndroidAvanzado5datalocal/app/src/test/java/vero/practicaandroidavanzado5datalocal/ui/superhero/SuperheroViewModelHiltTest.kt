package vero.practicaandroidavanzado5datalocal.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.keepcoding.androidavanzado.ui.SuperheroViewModelTest

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import vero.practicaandroidavanzado5datalocal.data.RepositoryImpl
import vero.practicaandroidavanzado5datalocal.data.local.LocalDataSource
import vero.practicaandroidavanzado5datalocal.data.remote.RemoteDataSource
import vero.practicaandroidavanzado5datalocal.domain.Repository
import vero.practicaandroidavanzado5datalocal.fakes.FakeLocalDataSource
import vero.practicaandroidavanzado5datalocal.fakes.FakeRemoteDataSource
import vero.practicaandroidavanzado5datalocal.modules.RepositoryModule
import vero.practicaandroidavanzado5datalocal.utils.generateHeros
import javax.inject.Inject

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class)
@UninstallModules(RepositoryModule::class)
class SuperheroViewModelHiltTest {

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class FakeRepositoryModule {
        companion object {

            @Provides
            fun providesFakeRemoteDataSource(): FakeRemoteDataSource {
                return FakeRemoteDataSource()
            }
        }

        @Binds
        abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository

        @Binds
        abstract fun bindsLocalDataSource(localDataSourceImpl: FakeLocalDataSource): LocalDataSource

        @Binds
        abstract fun bindsRemoteDataSource(remoteDataSourceImpl: FakeRemoteDataSource): RemoteDataSource
    }

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule val hiltRule = HiltAndroidRule(this)

    // UUT o SUT
    private lateinit var viewModel: SuperheroViewModelTest

    @Inject
    lateinit var repository: Repository


    @Before
    fun setUp() {
        hiltRule.inject()
        Dispatchers.setMain(UnconfinedTestDispatcher())
        viewModel = SuperheroViewModelTest(repository)
    }

    @Test
    fun `WHEN getHeros EXPECT successful response`() {
        // GIVEN
        val expected = generateHeros(16)

        // WHEN
        val actual = viewModel.getHeros()
        val actualLiveData = viewModel.heros.getOrAwaitValue()

        // THEN
        Truth.assertThat(actualLiveData).containsExactlyElementsIn(expected)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}
