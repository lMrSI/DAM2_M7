package com.example.proyectodam_m7

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.appm7.R


class DetallesPeliculas : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalles_peliculas_perfectas)
    }
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
    fun onForosButtonClick(view: View){
        val intent = Intent(this, Foros::class.java)
        startActivity(intent)
    }
}