package com.example.mvvm.repository

import com.example.mvvm.model.Product
import com.example.mvvm.services.RetrofitBuilder
import retrofit2.Callback


class ProductRepository {


    //criarProdutos() e buscarProdutos() vem lá do retrofit e da interface

    private val service = RetrofitBuilder.criarProdutos()

    fun getproducts(callback: Callback<List<Product>>){
        val call = service.buscarProdutos()
        call.enqueue(callback)
    }

}