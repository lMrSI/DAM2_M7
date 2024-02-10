package com.example.proyectodam_m7

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.appm7.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class Series : AppCompatActivity() {
    lateinit var navegation : BottomNavigationView
    private val mOnNavMenu = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
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
        setContentView(R.layout.series)
        navegation = findViewById(R.id.nav_menu)
        navegation.setOnNavigationItemSelectedListener(mOnNavMenu)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, SeriesFragment())
            addToBackStack("replacement")
            commit()
        }
    }
    fun onDetalleSeries(view: View){
        val intent = Intent(this, DetallesSeries::class.java)
        startActivity(intent)
    }
}