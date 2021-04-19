package com.example.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val adapterPais = PaaisesAdapter()
    var listPaaises : RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {
      listPaaises = findViewById(R.id.listPaaises)
    }
    private fun setupRecyclerView() {
        with(listPaaises){

        }
    }
}