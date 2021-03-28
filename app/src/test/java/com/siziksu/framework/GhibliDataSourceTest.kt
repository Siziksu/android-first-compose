package com.siziksu.framework

import com.siziksu.framework.api.ghibli.GhibliApi
import com.siziksu.framework.api.ghibli.GhibliDataSource
import com.siziksu.framework.api.ghibli.mapper.toLayerPort
import com.siziksu.port.repository.contracts.GhibliDataSourceContract
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GhibliDataSourceTest {

    private val ghibliApi = mockk<GhibliApi>()
    private lateinit var ghibliDataSource: GhibliDataSourceContract

    @Before
    fun setUp() {
        clearMocks(ghibliApi)
        ghibliDataSource = GhibliDataSource(ghibliApi)
    }

    @Test
    fun `when getGhibliFilms_run() is executed, it returns a list of domain films`() = runBlocking {
        val filmApiList = getFilmApiList()
        coEvery { ghibliApi.getFilms() } returns filmApiList
        val filmPortList = ghibliDataSource.getFilms()
        coVerify { ghibliApi.getFilms() }
        assertEquals(filmApiList.map { it.toLayerPort() }, filmPortList)
    }
}
