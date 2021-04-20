package com.example.mylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mylist.model.Countries
import kotlin.properties.Delegates

class PaaisesAdapter : RecyclerView.Adapter<PaaisesViewHolder>(), Filterable {

    var item: List<Countries> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    var paisitem: List<Countries> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    var filterItem = ArrayList<Countries>()

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

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                filterItem = if (charSearch.isEmpty()) {
                    paisitem as ArrayList<Countries>

                } else {
                    val resultList = ArrayList<Countries>()
                    for (row in paisitem) {
                        if (row.name.toLowerCase().contains(constraint.toString().toLowerCase())) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResultLis = FilterResults()
                filterResultLis.values - filterItem
                return filterResultLis
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                try {
                    item = results?.values as List<Countries>
                    notifyDataSetChanged()
                } catch (e: Exception) {
                    item = paisitem
                    print(e.message)

                }
            }

        }
    }

}

class PaaisesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Countries) {

        val text = itemView.findViewById<TextView>(R.id.textView)
        text.text = item.name

    }
}