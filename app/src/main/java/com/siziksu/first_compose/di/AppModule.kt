package com.siziksu.first_compose.di

import com.google.android.gms.location.LocationServices
import com.siziksu.first_compose.adapters.mapper.FilmsDomainToUi
import com.siziksu.first_compose.adapters.mapper.FilmsInadToDomain
import com.siziksu.first_compose.adapters.repository.StudioGhibliRepository
import com.siziksu.first_compose.adapters.repository.contracts.StudioGhibliDataSourceContract
import com.siziksu.first_compose.adapters.viewmodels.GhibliViewModel
import com.siziksu.first_compose.adapters.viewmodels.LocationViewModel
import com.siziksu.first_compose.domain.common.CoroutineCaseContract
import com.siziksu.first_compose.domain.contracts.StudioGhibliContract
import com.siziksu.first_compose.domain.model.Film
import com.siziksu.first_compose.domain.usecase.GetStudioGhibliFilms
import com.siziksu.first_compose.framework.api.common.RetrofitClient
import com.siziksu.first_compose.framework.api.common.RetrofitServer
import com.siziksu.first_compose.framework.api.ghibli.StudioGhibliApi
import com.siziksu.first_compose.framework.api.ghibli.StudioGhibliDataSource
import com.siziksu.first_compose.framework.api.ghibli.mapper.FilmsApiToInad
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

    single<StudioGhibliDataSourceContract> { StudioGhibliDataSource(get(named(API_STUDIO_GHIBLI)), get()) }

    single<StudioGhibliContract> { StudioGhibliRepository(get(), get()) }

    factory<CoroutineCaseContract<List<Film>, GetStudioGhibliFilms.Params>>(named(GET_FILMS_USE_CASE)) { GetStudioGhibliFilms(get()) }

    single { LocationServices.getFusedLocationProviderClient(androidContext()) }

    single { FilmsApiToInad() }
    single { FilmsDomainToUi() }
    single { FilmsInadToDomain() }

    viewModel { GhibliViewModel(get(named(GET_FILMS_USE_CASE)), get()) }
    viewModel { LocationViewModel(get()) }
}
