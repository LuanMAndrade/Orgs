package com.example.orgs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.orgs.databinding.ActivityDetalhesBinding

class DetalhesActivity : AppCompatActivity() {

    val binding by lazy { ActivityDetalhesBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val produto = intent.getParcelableExtra<Produto>("teste")
        with(binding){
            detalhesTitulo.text = produto?.nome
            detalhesTexto.text = produto?.descricao
            detalhesValor.text = produto?.valor.toString()
            detalhesImagem.load(produto?.image)
        }

    }
}