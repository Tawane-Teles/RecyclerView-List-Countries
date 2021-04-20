package com.example.mylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.model.Pais
import kotlin.properties.Delegates

class PaaisesAdapter : RecyclerView.Adapter<PaaisesViewHolder>() {
    var item: List<Pais> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    val paisitem: List<Pais> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    val filterItem: List<Pais> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaaisesViewHolder {
        return PaaisesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_pais, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: PaaisesViewHolder, position: Int) {
        val pais = item[position]
        holder.bind(pais)
    }
}

class PaaisesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Pais) {

        val text = itemView.findViewById<TextView>(R.id.textView)
        text.text = item.name

    }
}