package com.example.proyectodam_m7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appm7.Dato
import com.example.appm7.R
import com.example.appm7.RecycleView

class QuintoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout del fragmento
        val view = inflater.inflate(R.layout.list_foros, container, false)

        // Crear la lista de datos para el RecyclerView
        val listaDatos = listOf(
            Dato("Gaming", "[Spoilers] Overtake! Episode 7 Discussion Looks like everything is starting to crumble around Haruka.  This episodes ending really caught me by surprise."),
            Dato("Anime", "[Spoilers] Overtake! Episode 7 Discussion Looks like everything is starting to crumble around Haruka.  This episodes ending really caught me by surprise."),
            Dato("Series", "[Spoilers] Overtake! Episode 7 Discussion Looks like everything is starting to crumble around Haruka.  This episodes ending really caught me by surprise."),
            Dato("Películas", "[Spoilers] Overtake! Episode 7 Discussion Looks like everything is starting to crumble around Haruka.  This episodes ending really caught me by surprise."),
            // Agrega más datos según sea necesario
        )

        // Inicializar el RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.listRecycle)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Crear un adaptador para el RecyclerView y configurarlo
        val adaptador = RecycleView(listaDatos)
        recyclerView.adapter = adaptador

        return view
    }
}
