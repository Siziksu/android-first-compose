package com.siziksu.framework.di

import com.siziksu.framework.api.common.RetrofitClient
import com.siziksu.framework.api.common.RetrofitServer
import com.siziksu.framework.api.ghibli.GhibliApi
import com.siziksu.framework.api.ghibli.GhibliDataSource
import com.siziksu.port.repository.contracts.GhibliDataSourceContract
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

private const val API_GHIBLI = "Api:Ghibli"
private const val RETROFIT_GHIBLI = "Retrofit:Ghibli"

val appModule = module {

    single(named(RETROFIT_GHIBLI)) { RetrofitClient(get()).getRetrofit(RetrofitServer.GHIBLI) }
    single<GhibliApi>(named(API_GHIBLI)) { get<Retrofit>(named(RETROFIT_GHIBLI)).create(GhibliApi::class.java) }

    single<GhibliDataSourceContract> { GhibliDataSource(get(named(API_GHIBLI))) }
}
