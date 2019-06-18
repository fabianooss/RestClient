package com.example.restapi

import com.example.restapi.api.CarroService
import com.example.restapi.model.Carro
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://carros-app-example.herokuapp.com")
        .addConverterFactory(
            GsonConverterFactory.create())
        .build()

    fun carroService(): CarroService {
        return retrofit.create(CarroService::class.java)
    }


}