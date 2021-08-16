package com.example.mvvm.services

import com.example.mvvm.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductServiceinterface {

    @GET("/api/v1/products.json?brand=maybelline")
    fun buscarProdutos(): Call<List<Product>>
}