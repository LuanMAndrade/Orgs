package com.example.orgs

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val dao = ProdutosDAO()
        binding.button.setOnClickListener { configuraBotao(dao) }

        binding.imageView2
            .setOnClickListener {
                AlertDialog.Builder(this)
                    .setView(R.layout.caixa_dialogo)
                    .setPositiveButton("Confirmar", { _, _ -> Log.i("teste", "foi") })
                    .setNegativeButton("Cancelar", { _, _ -> })
                    .show()
            }


    }

    private fun configuraBotao(dao: ProdutosDAO) {
        val nome = binding.activityFormularioNomeTexto.text.toString()
        val descricao = binding.editDescricaoTexto.toString()
        val valor = binding.editValorTexto.toString().ifBlank { "0.00" }
        val produtoNovo = Produto(nome, descricao, valor.toDouble())
        dao.add(produtoNovo)
        finish()
    }
}