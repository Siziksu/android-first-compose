package com.siziksu.port.di

import com.google.android.gms.location.LocationServices
import com.siziksu.domain.common.CoroutineCaseContract
import com.siziksu.domain.contracts.GhibliRepositoryContract
import com.siziksu.domain.model.Film
import com.siziksu.domain.usecase.GetGhibliFilms
import com.siziksu.port.repository.GhibliRepository
import com.siziksu.port.viewmodels.GhibliViewModel
import com.siziksu.port.viewmodels.LocationViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val GET_FILMS_USE_CASE = "UseCase:GetGhibliFilms"

val portModule = module {

    single<GhibliRepositoryContract> { GhibliRepository(get()) }

    factory<CoroutineCaseContract<List<Film>, GetGhibliFilms.Params>>(named(GET_FILMS_USE_CASE)) { GetGhibliFilms(get()) }

    single { LocationServices.getFusedLocationProviderClient(androidContext()) }

    viewModel { GhibliViewModel(get(named(GET_FILMS_USE_CASE))) }
    viewModel { LocationViewModel(get()) }
}
