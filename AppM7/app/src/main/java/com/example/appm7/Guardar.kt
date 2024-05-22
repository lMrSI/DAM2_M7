package com.example.proyectodam_m7

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appm7.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class Guardar : AppCompatActivity() {
    lateinit var navegation: BottomNavigationView
    lateinit var textView7: TextView

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
        setContentView(R.layout.guardados)
        textView7.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                Log.d("TOUCH_EVENT", "TextView touched")
                textView7.showTooltip("Este es el menú de Guardado", event.rawX.toInt(), event.rawY.toInt())
            }
            true
        }

        navegation = findViewById(R.id.nav_menu)
        navegation.setOnNavigationItemSelectedListener(mOnNavMenu)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, SegundoFragment())
            addToBackStack("replacement")
            commit()
        }
    }

    private fun TextView.showTooltip(tooltipText: String, x: Int, y: Int) {
        Log.d("TOOLTIP", "Showing tooltip: $tooltipText")
        Toast.makeText(this@Guardar, tooltipText, Toast.LENGTH_SHORT).show()
    }
}
