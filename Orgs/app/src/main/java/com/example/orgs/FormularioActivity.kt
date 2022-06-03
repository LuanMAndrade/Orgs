package com.example.orgs

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity(R.layout.activity_formulario) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = ProdutosDAO()
        findViewById<Button>(R.id.button).setOnClickListener {
            configuraBotao(dao)
        }

        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView2.setOnClickListener {
            AlertDialog.Builder(this)
                .setView(R.layout.caixa_dialogo)
                .setPositiveButton("Confirmar", { _, _ -> })
                .setNegativeButton("Cancelar", { _, _ -> })
                .show()
        }


    }

    private fun configuraBotao(dao: ProdutosDAO) {
        val nome = findViewById<EditText>(R.id.activity_formulario_nome_texto).text.toString()
        val descricao = findViewById<EditText>(R.id.edit_descricao_texto).text.toString()
        val valor = findViewById<EditText>(R.id.edit_valor_texto)
            .text.toString().ifBlank { "0.00" }
        val produtoNovo = Produto(nome, descricao, valor.toDouble())
        dao.add(produtoNovo)
        finish()
    }
}