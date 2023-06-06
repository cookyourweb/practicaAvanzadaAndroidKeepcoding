package com.keepcoding.androidavanzado.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.keepcoding.androidavanzado.data.Repository
import com.keepcoding.androidavanzado.utils.generateHeros
import com.keepcoding.androidavanzado.utils.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SuperheroViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // UUT o SUT
    private lateinit var viewModel: SuperheroViewModel

    // Mocks
    private lateinit var repository: Repository
    // Fakes

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        repository = mockk()
        viewModel = SuperheroViewModel(repository)
    }

    @Test
    fun `WHEN getHeros EXPECT successful response`()  {
        // GIVEN
        val expected = generateHeros(16)
        coEvery { repository.getHeros() } returns expected

        // WHEN
        val actual = viewModel.getHeros()
        val actualLiveData = viewModel.heros.getOrAwaitValue()

        // THEN

    }

    // Revisar excepción
    @Test(expected = IllegalArgumentException::class)
    fun `WHEN getHeros EXPECT error response`() {
        val expected = generateHeros(16)
        coEvery { repository.getHeros() } throws IllegalArgumentException()

        // WHEN
        val actual = viewModel.getHeros()
        val actualLiveData = viewModel.heros.getOrAwaitValue()

        // THEN

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}
