package com.example.orgs

import android.content.Context
import android.icu.text.NumberFormat
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import java.util.*


class ListaProdutosAdapter(
    private val context: Context,
    lista: List<Produto>,
    var quandoClicaNoItem: (produto: Produto) -> Unit = {})
    : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val lista = lista.toMutableList()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var produto: Produto

        init {
            itemView.setOnClickListener {
                if (::produto.isInitialized) {
                    quandoClicaNoItem(produto)
                }
            }
        }

        fun vincula(produto: Produto) {
            this.produto = produto
            val nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = produto.nome
            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            descricao.text = produto.descricao
            val valor = itemView.findViewById<TextView>(R.id.valor)
            val formatador = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            } else {
                TODO("VERSION.SDK_INT < N")
            }
            val valorEmMoeda = formatador.format(produto.valor)
            valor.text = valorEmMoeda
            itemView.findViewById<ImageView>(R.id.imageView).load(produto.image)

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
