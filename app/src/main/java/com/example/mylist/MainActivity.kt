package com.example.mylist

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.model.Countries
import com.example.mylist.PaaisesAdapter as PaaisesAdapter1

class MainActivity : AppCompatActivity() {

    private val adapterCountries = PaaisesAdapter1()
    var listCountries: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countries: List<Countries> =
            listOf(Countries("Estrelinha"), Countries("Alemanha"), Countries("Argentina"))
        adapterCountries.item = countries
        adapterCountries.paisitem = countries

        setupViews()
        setupRecyclerView()

        searchView2.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapterCountries.filter.filter(query)
                return true 
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               adapterCountries.filter.filter(newText)
                return true
            }

        })
    }

    private fun setupViews() {
        listCountries = findViewById(R.id.listPaaises)
    }

    private fun setupRecyclerView() {

        listCountries?.layoutManager = LinearLayoutManager(this)
        listCountries?.adapter = adapterCountries

    }

}