package com.siziksu.framework.di

import com.siziksu.framework.api.common.RetrofitClient
import com.siziksu.framework.api.common.RetrofitServer
import com.siziksu.framework.api.ghibli.StudioGhibliApi
import com.siziksu.framework.api.ghibli.StudioGhibliDataSource
import com.siziksu.port.repository.contracts.StudioGhibliDataSourceContract
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

private const val API_STUDIO_GHIBLI = "Api:StudioGhibli"
private const val RETROFIT_STUDIO_GHIBLI = "Retrofit:StudioGhibli"

val appModule = module {

    single(named(RETROFIT_STUDIO_GHIBLI)) { RetrofitClient(get()).getRetrofit(RetrofitServer.STUDIO_GHIBLI) }
    single<StudioGhibliApi>(named(API_STUDIO_GHIBLI)) { get<Retrofit>(named(RETROFIT_STUDIO_GHIBLI)).create(StudioGhibliApi::class.java) }

    single<StudioGhibliDataSourceContract> { StudioGhibliDataSource(get(named(API_STUDIO_GHIBLI))) }
}
