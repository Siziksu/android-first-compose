package com.siziksu.port

import com.siziksu.domain.contracts.GhibliRepositoryContract
import com.siziksu.port.mapper.toLayerDomain
import com.siziksu.port.repository.GhibliRepository
import com.siziksu.port.repository.contracts.GhibliDataSourceContract
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GhibliRepositoryTest {

    private val ghibliDataSource = mockk<GhibliDataSourceContract>()
    private lateinit var ghibliRepository: GhibliRepositoryContract

    @Before
    fun setUp() {
        clearMocks(ghibliDataSource)
        ghibliRepository = GhibliRepository(ghibliDataSource)
    }

    @Test
    fun `when ghibliRepository_getFilms() is executed, it returns a list of domain films`() = runBlocking {
        val filmPortList = getFilmPortList()
        coEvery { ghibliDataSource.getFilms() } returns filmPortList
        val result = ghibliRepository.getFilms()
        coVerify { ghibliDataSource.getFilms() }
        assertEquals(filmPortList.map { it.toLayerDomain() }, result)
    }
}
