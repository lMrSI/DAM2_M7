package com.example.proyectodam_m7

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.appm7.R

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)


        //Lista del menú
        val arrayAdapter: ArrayAdapter<String>
        val itemsMenu = arrayOf("Inicio","Anime", "Series", "Peliculas","Guardados", "Salas", "Foros")
        val listaMenu = findViewById<ListView>(R.id.lista_menu)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemsMenu)
        listaMenu.adapter = arrayAdapter

        listaMenu.setOnItemClickListener { parent, view, position, id ->
            val element = arrayAdapter.getItem(position)
            when (element) {
                "Inicio" -> {
                    val intent = Intent(this, Inicio::class.java)
                    startActivity(intent)
                }

                "Anime" -> {
                    val intent = Intent(this, Anime::class.java)
                    startActivity(intent)
                }
                "Series" -> {
                    val intent = Intent(this, Series::class.java)
                    startActivity(intent)
                }
                "Peliculas" -> {
                    val intent = Intent(this, Peliculas::class.java)
                    startActivity(intent)
                }
                "Guardados" -> {
                    val intent = Intent(this, Guardar::class.java)
                    startActivity(intent)
                }
                "Salas" -> {
                    val intent = Intent(this, Salas::class.java)
                    startActivity(intent)
                }
                "Foros" -> {
                    val intent = Intent(this, Foros::class.java)
                    startActivity(intent)
            }

        }
    }
}
}
