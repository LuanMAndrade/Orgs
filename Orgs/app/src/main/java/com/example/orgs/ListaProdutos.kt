package com.example.orgs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaProdutos(private val context: Context, lista: List<Produto>) :
    RecyclerView.Adapter<ListaProdutos.ViewHolder>() {

    private val lista = lista.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(produto: Produto) {
            val nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = produto.nome
            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            descricao.text = produto.descricao
            val valor = itemView.findViewById<TextView>(R.id.valor)
            valor.text = produto.valor

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.produto, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vincula(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun atualiza(produtos: List<Produto>) {
        this.lista.clear()
        this.lista.addAll(produtos)
        notifyDataSetChanged()

    }
}
