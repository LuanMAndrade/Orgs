package com.example.orgs

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)
        val dao = ProdutosDAO()
        findViewById<Button>(R.id.button).setOnClickListener{
//            val nome = findViewById<EditText>(R.id.edit_nome).text.toString()
//            val descricao = findViewById<EditText>(R.id.edit_descricao).text.toString()
//            val valor = findViewById<EditText>(R.id.edit_valor).text.toString()
//            val produtoNovo = Produto(nome, descricao, valor)
//            dao.add(produtoNovo)
            dao.add(Produto("Luan","Muniz",10.00))
            finish()
        }

    }
}