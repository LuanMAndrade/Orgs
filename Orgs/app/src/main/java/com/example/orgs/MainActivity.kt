package com.example.orgs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val dao = ProdutosDAO()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        Log.i("teste", "Até aqui foi1")
        dao.add(Produto("luan", "Muniz", "00"))
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        Log.i("teste", "Até aqui foi3")
        recyclerView.adapter = ListaProdutos(this, dao.search())
        Log.i("teste", "Até aqui foi4")
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        Log.i("teste", "Até aqui foi5")
        fab.setOnClickListener { startActivity(Intent(this, FormularioActivity::class.java)) }
    }
}