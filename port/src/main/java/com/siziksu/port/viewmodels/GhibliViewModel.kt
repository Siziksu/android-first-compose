package com.siziksu.port.viewmodels

import androidx.lifecycle.ViewModel
import com.siziksu.domain.common.CoroutineCaseContract
import com.siziksu.domain.model.Film
import com.siziksu.domain.usecase.GetGhibliFilms
import com.siziksu.port.common.onError
import com.siziksu.port.mapper.toLayerPort
import com.siziksu.port.model.FilmPort
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GhibliViewModel(
    private val getGhibliFilms: CoroutineCaseContract<List<Film>, GetGhibliFilms.Params>
) : ViewModel() {

    private val _films = MutableStateFlow<List<FilmPort>>(arrayListOf())
    val films: StateFlow<List<FilmPort>> = _films

    private var isFirstTime: Boolean = true

    override fun onCleared() {
        super.onCleared()
        getGhibliFilms.cancel()
    }

    fun init() {
        if (isFirstTime) {
            isFirstTime = false
            getGhibliFilms.run(
                { films -> _films.value = films.map { it.toLayerPort() }.sortedBy { it.title[0] } },
                { onError(it, TAG, METHOD_GET_FILMS) },
                GetGhibliFilms.Params()
            )
        }
    }

    companion object {

        private const val TAG = "GhibliViewModel"
        private const val METHOD_GET_FILMS = "GhibliViewModel.getGhibliFilms()"
    }
}
