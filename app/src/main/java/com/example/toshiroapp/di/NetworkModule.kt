package com.example.toshiroapp.di

import com.example.toshiroapp.model.air.AirEntity
import com.example.toshiroapp.model.weather.WeatherEntity
import com.example.toshiroapp.network.AirService
import com.example.toshiroapp.network.RequestInterceptor
import com.example.toshiroapp.network.WeatherClient
import com.example.toshiroapp.network.WeatherService
import com.skydoves.sandwich.ResponseDataSource
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL_WEATHER = "http://www.hmhweather.xyz/api/"
const val BASE_URL_AIR = "http://aqi.wd.amberweather.com/"

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(BASE_URL_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        Retrofit.Builder()
                .client(get<OkHttpClient>())
                .baseUrl(BASE_URL_AIR)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    single { get<Retrofit>().create(AirService::class.java) }

    single { get<Retrofit>().create(WeatherService::class.java) }

    single { WeatherClient(get(),get()) }

    single { ResponseDataSource<WeatherEntity>() }

    single { ResponseDataSource<AirEntity>() }
}
