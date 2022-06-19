package com.example.orgs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val dao = ProdutosDAO()
    private val adapter = ListaProdutosAdapter(this, dao.search())
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecyclerView()
    }


    override fun onResume() {
        super.onResume()
        configuraFab()
        adapter.atualiza(dao.search())
    }

    private fun configuraFab() {
        val fab = binding.floatingActionButton
        fab.setOnClickListener {
            startActivity(Intent(this, FormularioActivity::class.java))
        }
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        adapter.quandoClicaNoItem = {
            val intent = Intent(this, DetalhesActivity::class.java)
                .apply { putExtra("teste", it) }
            startActivity(intent)

        }
    }
}