package com.example.appm7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecycleView(private val listaDatos: List<Dato>) : RecyclerView.Adapter<RecycleView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.card)
        val titleTextView: TextView = itemView.findViewById(R.id.title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descripcion)
    }

    // Crea nuevos elementos ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.foros, parent, false)
        return ViewHolder(itemView)
    }

    // Reemplaza el contenido de un ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datoActual = listaDatos[position]
        holder.titleTextView.text = datoActual.titulo
        holder.descriptionTextView.text = datoActual.descripcion
    }

    // Devuelve el número total de elementos en el conjunto de datos
    override fun getItemCount() = listaDatos.size
}

data class Dato(val titulo: String, val descripcion: String)
