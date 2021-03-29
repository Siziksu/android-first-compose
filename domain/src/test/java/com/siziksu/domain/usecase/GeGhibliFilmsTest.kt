package com.siziksu.domain.usecase

import com.siziksu.domain.common.CoroutineCaseContract
import com.siziksu.domain.contracts.GhibliRepositoryContract
import com.siziksu.domain.model.Film
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.ArrayList

class GeGhibliFilmsTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = CoroutinesTestRule()

    private val ghibliRepository = mockk<GhibliRepositoryContract>()
    private lateinit var getGhibliFilms: CoroutineCaseContract<List<Film>, GetGhibliFilms.Params>

    @Before
    fun setUp() {
        clearMocks(ghibliRepository)
        getGhibliFilms = GetGhibliFilms(ghibliRepository)
    }

    @Test
    fun `when getGhibliFilms_run() is executed, it returns a list of domain films`() = runBlocking {
        val filmDomainList = getFilmDomainList()
        val result = ArrayList<Film>()
        coEvery { ghibliRepository.getFilms() } returns filmDomainList
        getGhibliFilms.run({ result.addAll(it) }, {}, GetGhibliFilms.Params())
        coVerify { ghibliRepository.getFilms() }
        assertEquals(filmDomainList, result)
    }
}
