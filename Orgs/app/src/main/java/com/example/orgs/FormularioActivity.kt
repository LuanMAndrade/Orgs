package com.example.orgs

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.orgs.databinding.ActivityFormularioBinding
import com.example.orgs.databinding.CaixaDialogoBinding

class FormularioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioBinding.inflate(layoutInflater)
    }
    var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dao = ProdutosDAO()

        binding.button.setOnClickListener { configuraBotao(dao) }

        binding.imageView2
            .setOnClickListener {
                val bindingCaixa = CaixaDialogoBinding.inflate(layoutInflater)
                AlertDialog.Builder(this)
                    .setView(bindingCaixa.root)
                    .setPositiveButton("Confirmar", { _, _ ->
                        binding.imageView2.load(bindingCaixa.url.text.toString())
                        binding.root.refreshDrawableState()
                    })
                    .setNegativeButton("Cancelar", { _, _ -> })
                    .show()

                bindingCaixa.button2.setOnClickListener {
                    url = bindingCaixa.url.text.toString()
                    bindingCaixa.imageView3.load(url)
                    bindingCaixa.imageView3.refreshDrawableState()
                }
            }
    }

    private fun configuraBotao(dao: ProdutosDAO) {
        val nome = binding.activityFormularioNomeTexto.text.toString()
        val descricao = binding.editDescricaoTexto.text.toString()
        val valor = binding.editValorTexto.text.toString().ifBlank { "0.00" }
        val produtoNovo = Produto(nome, descricao, valor.toDouble(), url)
        dao.add(produtoNovo)
        finish()
    }
}