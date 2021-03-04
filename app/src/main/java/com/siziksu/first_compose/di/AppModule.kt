package com.siziksu.first_compose.di

import com.google.android.gms.location.LocationServices
import com.siziksu.first_compose.data.common.RetrofitClient
import com.siziksu.first_compose.data.common.RetrofitServer
import com.siziksu.first_compose.data.datasource.api.StudioGhibliApi
import com.siziksu.first_compose.data.datasource.api.StudioGhibliDataSource
import com.siziksu.first_compose.data.mapper.FilmsDataToDomain
import com.siziksu.first_compose.data.repository.StudioGhibliRepository
import com.siziksu.first_compose.domain.common.CoroutineCaseContract
import com.siziksu.first_compose.domain.model.FilmDomain
import com.siziksu.first_compose.domain.repository.StudioGhibliRepositoryContract
import com.siziksu.first_compose.domain.usecase.GetStudioGhibliFilms
import com.siziksu.first_compose.ui.feature.main.ghibli.GhibliViewModel
import com.siziksu.first_compose.ui.feature.main.ghibli.mapper.FilmsDomainToUi
import com.siziksu.first_compose.ui.feature.main.location.LocationViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

private const val API_STUDIO_GHIBLI = "Api:StudioGhibli"
private const val RETROFIT_STUDIO_GHIBLI = "Retrofit:StudioGhibli"
private const val GET_FILMS_USE_CASE = "UseCase:GetStudioGhibliFilms"

val appModule = module {

    single(named(RETROFIT_STUDIO_GHIBLI)) { RetrofitClient(get()).getRetrofit(RetrofitServer.STUDIO_GHIBLI) }
    single<StudioGhibliApi>(named(API_STUDIO_GHIBLI)) { get<Retrofit>(named(RETROFIT_STUDIO_GHIBLI)).create(StudioGhibliApi::class.java) }

    single { StudioGhibliDataSource(get(named(API_STUDIO_GHIBLI))) }

    single<StudioGhibliRepositoryContract> { StudioGhibliRepository(get(), get()) }

    factory<CoroutineCaseContract<List<FilmDomain>, GetStudioGhibliFilms.Params>>(named(GET_FILMS_USE_CASE)) { GetStudioGhibliFilms(get()) }

    single { LocationServices.getFusedLocationProviderClient(androidContext()) }

    single { FilmsDataToDomain() }
    single { FilmsDomainToUi() }

    viewModel { GhibliViewModel(get(named(GET_FILMS_USE_CASE)), get()) }
    viewModel { LocationViewModel(get()) }
}
