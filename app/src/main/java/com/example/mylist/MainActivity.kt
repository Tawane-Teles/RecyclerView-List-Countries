package com.example.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.model.Pais

class MainActivity : AppCompatActivity() {

    private val adapterPais = PaaisesAdapter()
    var listPaaises : RecyclerView?=null
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
        with(listPaaises){

            listPaaises?.layoutManager = LinearLayoutManager ("")

        }
    }
}