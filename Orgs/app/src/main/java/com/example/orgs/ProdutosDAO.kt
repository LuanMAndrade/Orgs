package com.example.orgs

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