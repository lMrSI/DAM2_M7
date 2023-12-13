package com.example.proyectodam_m7

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)
    }
    fun onInicioButtonClick(view: View) {
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }

}

