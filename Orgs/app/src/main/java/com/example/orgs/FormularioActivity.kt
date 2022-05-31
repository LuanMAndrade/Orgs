package com.example.orgs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FormularioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)
        findViewById<Button>(R.id.button).setOnClickListener{
            val nome = findViewById<TextView>(R.id.edit_nome).text.toString()
            val descricao = findViewById<TextView>(R.id.edit_descricao).text.toString()
            val valor = findViewById<TextView>(R.id.edit_valor).text.toString()
            val produtoNovo = Produto(nome, descricao, valor)
            val dao = ProdutosDAO()
            dao.add(produtoNovo)
        }

    }
}