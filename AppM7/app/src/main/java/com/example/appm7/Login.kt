package com.example.proyectodam_m7

import DBHelper
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appm7.InformeActividad
import com.example.appm7.R

class Login : AppCompatActivity() {
    private lateinit var dbHelper: DBHelper
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var textView3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        etEmail = findViewById(R.id.editTextTextEmailAddress)
        etPassword = findViewById(R.id.editTextTextPassword)
        textView3 = findViewById(R.id.textView3)
        dbHelper = DBHelper(this)
        if (Build.VERSION.SDK_INT > 25) {
            textView3.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    textView3.showTooltip("Menú para inciar sesión, registrarse o crear un informe", event.rawX.toInt(), event.rawY.toInt())
                }
                true
            }
        }
    }

    fun onRegistroButtonClick(view: View) {
        val intent = Intent(this, Registro::class.java)
        startActivity(intent)
    }

    fun onInicioButtonClick(view: View) {
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        if (validarCredenciales(email, password)) {
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Correo electrónico o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }

    fun onGenerarInforme(view: View){
        val intent = Intent(this, InformeActividad::class.java)
        startActivity(intent)
    }
    private fun validarCredenciales(email: String, password: String): Boolean {
        return dbHelper.validarUsuario(email, password)
    }
    fun TextView.showTooltip(tooltipText: String, x: Int, y: Int) {
        Toast.makeText(this@Login, tooltipText, Toast.LENGTH_SHORT).show()
    }
}
