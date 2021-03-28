package com.siziksu.first_compose.adapters.viewmodels

import androidx.lifecycle.ViewModel
import com.siziksu.first_compose.adapters.mapper.FilmsDomainToUi
import com.siziksu.first_compose.common.onError
import com.siziksu.first_compose.domain.common.CoroutineCaseContract
import com.siziksu.first_compose.domain.model.Film
import com.siziksu.first_compose.domain.usecase.GetStudioGhibliFilms
import com.siziksu.first_compose.framework.ui.feature.main.ghibli.model.FilmUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GhibliViewModel(
    private val getStudioGhibliFilms: CoroutineCaseContract<List<Film>, GetStudioGhibliFilms.Params>,
    private val filmsDomainToUi: FilmsDomainToUi
) : ViewModel() {

    private val _films = MutableStateFlow<List<FilmUi>>(arrayListOf())
    val films: StateFlow<List<FilmUi>> = _films

    private var isFirstTime: Boolean = true

    override fun onCleared() {
        super.onCleared()
        getStudioGhibliFilms.cancel()
    }

    fun init() {
        if (isFirstTime) {
            isFirstTime = false
            getStudioGhibliFilms.run(
                { films -> _films.value = filmsDomainToUi.map(films).sortedBy { it.title[0] } },
                { onError(it, TAG, METHOD_GET_FILMS) },
                GetStudioGhibliFilms.Params()
            )
        }
    }

    companion object {

        private const val TAG = "GhibliViewModel"
        private const val METHOD_GET_FILMS = "GhibliViewModel.getStudioGhibliFilms()"
    }
}
