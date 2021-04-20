package com.example.mylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.model.Pais
import com.example.mylist.PaaisesAdapter as PaaisesAdapter1

class MainActivity : AppCompatActivity() {

    private val adapterPais = PaaisesAdapter1()
    var listPaaises: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val paaises: List<Pais> = listOf(Pais("Estrelinha"), Pais("Alemanha"), Pais("Argentina"))
        adapterPais.item = paaises

        setupViews()
        setupRecyclerView()
    }

    private fun setupViews() {
        listPaaises = findViewById(R.id.listPaaises)
    }

    private fun setupRecyclerView() {

        listPaaises?.layoutManager = LinearLayoutManager (this)
        listPaaises?. adapter = adapterPais

        }
}
}