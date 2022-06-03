package com.example.orgs

import com.example.orgs.databinding.ActivityMainBinding

class ProdutosDAO {

    fun add (produto : Produto) {
        data.add(produto)
    }

    fun search(): List<Produto> {
        return data.toList()
    }


    companion object {
       private val data = mutableListOf<Produto>()
    }


}