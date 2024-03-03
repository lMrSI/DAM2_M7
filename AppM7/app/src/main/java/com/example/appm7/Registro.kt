package com.example.proyectodam_m7

import DBHelper
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appm7.R
import com.example.appm7.Usuario

class Registro : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper
    private lateinit var etName: EditText
    private lateinit var etSurname: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etPassword2: EditText
    private lateinit var etPhone: EditText
    private lateinit var btnAceptar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        etName = findViewById(R.id.etName)
        etSurname = findViewById(R.id.etSurname)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etPassword2 = findViewById(R.id.etPassword2)
        etPhone = findViewById(R.id.etPhone)
        btnAceptar = findViewById(R.id.btnAceptar)

        dbHelper = DBHelper(this)

        btnAceptar.setOnClickListener {
            val nombre = etName.text.toString()
            val apellido = etSurname.text.toString()
            val email = etEmail.text.toString()
            val contraseña = etPassword.text.toString()
            val contraseña2 = etPassword2.text.toString()
            val telefono = etPhone.text.toString()

            if (contraseña != contraseña2) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = Usuario(0, nombre, apellido, email, contraseña, telefono)
            insertarUsuario(usuario)
        }
    }

    private fun insertarUsuario(usuario: Usuario) {
        val result = dbHelper.insertarUsuario(usuario)
        if (result != -1L) {
            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
            onInicioButtonClick(btnAceptar)
        } else {
            Toast.makeText(this, "Error al registrar el usuario", Toast.LENGTH_SHORT).show()
        }
    }

    fun onInicioButtonClick(view: View) {
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }
}
