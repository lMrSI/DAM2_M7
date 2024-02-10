package com.example.proyectodam_m7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appm7.Dato
import com.example.appm7.R
import com.example.appm7.RecycleView


class Foros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_foros)
        val listaDatos = listOf(
            Dato("Gaming", "[Spoilers] Overtake! Episode 7 Discussion Looks like everything is starting to crumble around Haruka.  This episodes ending really caught me by surprise."),
            Dato("Anime", "[Spoilers] Overtake! Episode 7 Discussion Looks like everything is starting to crumble around Haruka.  This episodes ending really caught me by surprise."),
            Dato("Series", "[Spoilers] Overtake! Episode 7 Discussion Looks like everything is starting to crumble around Haruka.  This episodes ending really caught me by surprise."),
            Dato("Películas", "[Spoilers] Overtake! Episode 7 Discussion Looks like everything is starting to crumble around Haruka.  This episodes ending really caught me by surprise."),
            // Agrega más datos según sea necesario
        )

        // Inicializar el RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.listRecycle)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Crear un adaptador para el RecyclerView y configurarlo
        val adaptador = RecycleView(listaDatos)
        recyclerView.adapter = adaptador
    }
    /*
    fun onSalasButtonClick(view: View){
        val intent = Intent(this, Salas::class.java)
        startActivity(intent)
    }
    fun onInicioButtonClick(view: View) {
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }
    fun onSaveButtonClick(view: View){
        val intent = Intent(this, Guardar::class.java)
        startActivity(intent)
    }
    fun onPerfilsButtonClick(view: View){
        val intent = Intent(this, Perfil::class.java)
        startActivity(intent)
    }
     */
}