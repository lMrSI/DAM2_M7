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

}

