package com.example.proyectodam_m7

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio) }

    fun onVideojuegosButtonClick(view: View) {
        val intent = Intent(this, Videojuegos::class.java)
        startActivity(intent)
    }
    fun onPeliculasButtonClick(view: View) {
        val intent = Intent(this, Peliculas::class.java)
        startActivity(intent)
    }
    fun onSeriesButtonClick(view: View) {
        val intent = Intent(this, Series::class.java)
        startActivity(intent)
    }
    fun onAnimeButtonClick(view: View) {
        val intent = Intent(this, Anime::class.java)
        startActivity(intent)
    }
    fun onSaveButtonClick(view: View){
        val intent = Intent(this, Guardar::class.java)
        startActivity(intent)
    }
    fun onForosButtonClick(view: View){
        val intent = Intent(this, Foros::class.java)
        startActivity(intent)
    }
    fun onPerfilsButtonClick(view: View){
        val intent = Intent(this, Perfil::class.java)
        startActivity(intent)
    }
    fun onSalasButtonClick(view: View){
        val intent = Intent(this, Salas::class.java)
        startActivity(intent)
    }

}

