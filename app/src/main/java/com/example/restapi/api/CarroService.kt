package com.example.restapi.api

import com.example.restapi.model.Carro
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface CarroService {

    @GET("/carro")
    fun find(): Call<List<Carro>>

    @POST("/carro")
    fun save(carro: Carro)




}