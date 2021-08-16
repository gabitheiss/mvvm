package com.example.mvvm.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://makeup-api.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun criarProdutos() :  ProductServiceinterface {
        return retrofit.create(ProductServiceinterface::class.java)
    }
}