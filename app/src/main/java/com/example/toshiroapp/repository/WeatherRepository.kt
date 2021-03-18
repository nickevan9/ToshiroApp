package com.example.toshiroapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.toshiroapp.model.weather.WeatherEntity
import com.example.toshiroapp.network.WeatherClient
import com.example.toshiroapp.persistence.WeatherDao
import com.skydoves.sandwich.ResponseDataSource
import com.skydoves.sandwich.disposables.CompositeDisposable
import com.skydoves.sandwich.onSuccess
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import timber.log.Timber

class WeatherRepository constructor(
    private val weatherClient: WeatherClient,
    private val weatherDataSource : ResponseDataSource<WeatherEntity>,
    private val weatherDao: WeatherDao

) {

    init {
        Timber.d("Injection WeatherRepository")
    }

    suspend fun loadWeather(
        lat : Double,
        lon : Double,
        disposable : CompositeDisposable,
        error : (String?) -> Unit
    ) = withContext(Dispatchers.IO){
        val liveData = MutableLiveData<List<WeatherEntity>>()
        val weathers = weatherDao.getWeatherList()

        if (weathers.isEmpty()){
            val weatherRes = async { weatherClient.fetchWeather(lat,lon,weatherDataSource,disposable){ apiResponse ->
                apiResponse.onSuccess {
                    data.whatIfNotNull {
                        
                    }
                }
            } }
        }
    }
}