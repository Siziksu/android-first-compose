package com.siziksu.port

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.siziksu.domain.common.CoroutineCaseContract
import com.siziksu.domain.model.Film
import com.siziksu.domain.usecase.GetGhibliFilms
import com.siziksu.port.common.onError
import com.siziksu.port.mapper.toLayerPort
import com.siziksu.port.model.FilmPort
import com.siziksu.port.viewmodels.GhibliViewModel
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.slot
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GhibliViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val observer = mockk<Observer<List<FilmPort>>>(relaxed = true)
    private val getGhibliFilms = mockk<CoroutineCaseContract<List<Film>, GetGhibliFilms.Params>>()
    private lateinit var ghibliViewModel: GhibliViewModel

    @Before
    fun setUp() {
        clearMocks(observer, getGhibliFilms)
        mockkStatic("com.siziksu.port.common.LogCatKt")
        ghibliViewModel = GhibliViewModel(getGhibliFilms)
    }

    @Test
    fun `when ghibliViewModel_init() is executed`() = runBlocking {
        val filmDomainList = getFilmDomainList()
        val slot = slot<List<FilmPort>>()
        val directSlot = slot<(List<Film>) -> Unit>()

        every { getGhibliFilms.run(capture(directSlot), any(), any()) } returns run { }

        ghibliViewModel.films.asLiveData().observeForever(observer)

        ghibliViewModel.init()

        directSlot.captured(getFilmDomainList())

        verify {
            getGhibliFilms.run(any(), any(), any())
            observer.onChanged(any())
            observer.onChanged(capture(slot))
        }
        assertEquals(filmDomainList.map { it.toLayerPort() }, slot.captured)
        ghibliViewModel.films.asLiveData().removeObserver(observer)
    }

    @Test
    fun `when ghibliViewModel_init() is executed and returns an error`() = runBlocking {
        val directSlot = slot<(Throwable) -> Unit>()
        val errorSlot = slot<Throwable>()

        every { getGhibliFilms.run(any(), capture(directSlot), any()) } returns run { }

        ghibliViewModel.init()

        directSlot.captured(InvalidUser())

        verify {
            getGhibliFilms.run(any(), any(), any())
            onError(capture(errorSlot), any(), any())
        }

        assertTrue(errorSlot.captured is InvalidUser)
        assertEquals("Invalid user", errorSlot.captured.message)
    }

    class InvalidUser : Exception("Invalid user")
}
