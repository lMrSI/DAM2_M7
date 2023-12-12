package com.example.proyectodam_m7

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
        val buttonGaming = findViewById<Button>(R.id.buttonGaming)
        if (buttonGaming != null) {
            buttonGaming.setOnClickListener {
                val intent = Intent(this, Videojuegos::class.java)
                startActivity(intent)
            }
        } else {
            Log.e("MainActivity", "ButtonGaming is null")
        }
    }
    fun onForosButtonClick(view: View) {
        val intent = Intent(this, ForosActivity::class.java)
        startActivity(intent)
    }
}
