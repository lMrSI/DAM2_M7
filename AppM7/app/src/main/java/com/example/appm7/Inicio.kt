package com.example.proyectodam_m7

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.TooltipCompat
import com.example.appm7.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Inicio : AppCompatActivity() {
    lateinit var navegation: BottomNavigationView
    lateinit var textViewVerconnect: TextView
    lateinit var imageView47: ImageView

    private val mOnNavMenu = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.primerFragment -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainer, PrimerFragment())
                    addToBackStack("replacement")
                    commit()
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.segundoFragment -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainer, SegundoFragment())
                    addToBackStack("replacement")
                    commit()
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.tercerFragment -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainer, TercerFragment())
                    addToBackStack("replacement")
                    commit()
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.cuartoFragment -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainer, CuartoFragment())
                    addToBackStack("replacement")
                    commit()
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.quintoFragment -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainer, QuintoFragment())
                    addToBackStack("replacement")
                    commit()
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)
        textViewVerconnect = findViewById(R.id.textView8)
        imageView47 = findViewById(R.id.imageView47)

        if (Build.VERSION.SDK_INT > 25) {
            textViewVerconnect.setOnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    textViewVerconnect.showTooltip("Clickea para la navegacuión entre plataformas", event.rawX.toInt(), event.rawY.toInt())
                }
                true
            }

            imageView47.setOnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    imageView47.showTooltip("Este es el menu de inicio", event.rawX.toInt(), event.rawY.toInt())
                }
                true
            }
        }

        navegation = findViewById(R.id.nav_menu)
        navegation.setOnNavigationItemSelectedListener(mOnNavMenu)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, PrimerFragment())
            addToBackStack("replacement")
            commit()
        }
    }

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

    private fun TextView.showTooltip(tooltipText: String, x: Int, y: Int) {
        Toast.makeText(this@Inicio, tooltipText, Toast.LENGTH_SHORT).show()
    }

    private fun ImageView.showTooltip(tooltipText: String, x: Int, y: Int) {
        Toast.makeText(this@Inicio, tooltipText, Toast.LENGTH_SHORT).show()
    }
}
