package com.example.mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm.R
import com.example.mvvm.model.Product

class ProductAdapter(var listOfProducts: MutableList<Product>) :
    RecyclerView.Adapter<ItensProductsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItensProductsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.itens_lista_card, parent, false)
        return ItensProductsViewHolder(view)
    }


    override fun onBindViewHolder(holder: ItensProductsViewHolder, position: Int) {
        listOfProducts[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfProducts.size
    }

    fun refresh(products: List<Product>) {
        listOfProducts = mutableListOf()
        listOfProducts.addAll(products)
        notifyDataSetChanged()
    }

}

class ItensProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(product: Product) {
        itemView.findViewById<TextView>(R.id.idName)?.apply {
            text = product.nome
        }


        itemView.findViewById<ImageView>(R.id.idImagem)?.apply {
            Glide.with(context)
                .load(product.imagem)
                .placeholder(R.drawable.ic_launcher_background)
                .into(this)
        }

        itemView.findViewById<TextView>(R.id.idType)?.apply {
            text = product.tipo
        }

        itemView.findViewById<TextView>(R.id.idCor)?.apply {
            text = product.cor?.firstOrNull()?.productColor
        }

        itemView.findViewById<TextView>(R.id.idPreco)?.apply {
            text = "R$ ${product.preco}"
        }
    }
}

