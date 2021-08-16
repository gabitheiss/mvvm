package com.example.mvvm.repository

import com.example.mvvm.model.Product
import com.example.mvvm.services.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductRepository {


    //criarProdutos() e buscarProdutos() vem lá do retrofit e da interface

    private val service = RetrofitBuilder.criarProdutos()

    fun getProducts(callback: (List<Product>?, String?) -> Unit) {
        val call = service.buscarProdutos()
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                response.body()?.let {
                    callback(it, null)
                    callback(null, "Sucesso!!!!!!")
                }
                if (response.code() != 200) {
                    callback(null, "Algum erro desconhecido")
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                callback(null, t.localizedMessage)
            }


        })

    }
}