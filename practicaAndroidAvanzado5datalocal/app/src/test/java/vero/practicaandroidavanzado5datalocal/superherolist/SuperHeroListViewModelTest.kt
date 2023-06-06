package vero.practicaandroidavanzado5datalocal.ui.superherolist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import vero.practicaandroidavanzado5datalocal.domain.Repository
import vero.practicaandroidavanzado5datalocal.ui.superherolist.SuperHeroListViewModel
import vero.practicaandroidavanzado5datalocal.utils.generateHeros
import vero.practicaandroidavanzado5datalocal.utils.getOrAwaitValue

@OptIn(ExperimentalCoroutinesApi::class)
class SuperHeroListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // SUT o UUT
    private lateinit var superHeroListViewModel: SuperHeroListViewModel

    // Dependencies
    private lateinit var repository: Repository

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup(){
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun `WHEN getSuperheros EXPECTS success returns list of superheros`() = runTest {
        // GIVEN
        repository = mockk()
        superHeroListViewModel = SuperHeroListViewModel(repository)
        coEvery {  repository.getHerosWithCache() } returns generateHeros()

        // WHEN
        val actual = superHeroListViewModel.getSuperheros()
        val actualLiveData = superHeroListViewModel.heros.getOrAwaitValue()

        // THEN
        Truth.assertThat(actualLiveData).containsExactlyElementsIn(generateHeros())
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }
}
