package com.siziksu.port.di

import com.google.android.gms.location.LocationServices
import com.siziksu.domain.common.CoroutineCaseContract
import com.siziksu.domain.contracts.StudioGhibliContract
import com.siziksu.domain.model.Film
import com.siziksu.domain.usecase.GetStudioGhibliFilms
import com.siziksu.port.repository.StudioGhibliRepository
import com.siziksu.port.viewmodels.GhibliViewModel
import com.siziksu.port.viewmodels.LocationViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val GET_FILMS_USE_CASE = "UseCase:GetStudioGhibliFilms"

val portModule = module {

    single<StudioGhibliContract> { StudioGhibliRepository(get()) }

    factory<CoroutineCaseContract<List<Film>, GetStudioGhibliFilms.Params>>(named(GET_FILMS_USE_CASE)) { GetStudioGhibliFilms(get()) }

    single { LocationServices.getFusedLocationProviderClient(androidContext()) }

    viewModel { GhibliViewModel(get(named(GET_FILMS_USE_CASE))) }
    viewModel { LocationViewModel(get()) }
}
