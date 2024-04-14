package com.example.appm7

import Informe
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.ChartData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class InformeActividad : AppCompatActivity() {
    private lateinit var informe: Informe
    private lateinit var datos: ChartData<*>
    private lateinit var chart: LineChart
    private lateinit var editNombre: EditText
    private lateinit var editApellido: EditText
    private lateinit var editEdad: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.informe)

        chart = findViewById(R.id.chart)
        val btnGeneratePdf: Button = findViewById(R.id.btn_generate_pdf)
        val btnSend: Button = findViewById(R.id.btn_send)
        editNombre = findViewById(R.id.edit_text_nombre)
        editApellido = findViewById(R.id.edit_text_apellido)
        editEdad = findViewById(R.id.edit_text_edad)

        informe = Informe(this)

        btnGeneratePdf.setOnClickListener {
            // Obtener los datos del gráfico
            val nombre = editNombre.text.toString()
            val apellido = editApellido.text.toString()
            val edad = editEdad.text.toString().toFloatOrNull()
            if (nombre.isNotEmpty() && apellido.isNotEmpty() && edad != null) {
                val datos = obtenerDatos(nombre, apellido, edad)
                val archivoPDF = informe.generarInformeEnPDF(datos, chart, "Informe de $nombre $apellido")
                if (archivoPDF != null) {
                    Toast.makeText(this, "Informe generado como PDF", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error al generar el informe como PDF", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Ingrese todos los campos correctamente", Toast.LENGTH_SHORT).show()
            }
        }

        btnSend.setOnClickListener {
            val nombre = editNombre.text.toString()
            val apellido = editApellido.text.toString()
            val edad = editEdad.text.toString().toFloatOrNull()
            if (nombre.isNotEmpty() && apellido.isNotEmpty() && edad != null) {
                val datos = obtenerDatos(nombre, apellido, edad)
                informe.generarInformeEnAplicacion(datos, chart, "Informe de $nombre $apellido")
                informe.generarInformeEnPDF(datos, chart, "Informe de $nombre $apellido")
            } else {
                Toast.makeText(this, "Ingrese todos los campos correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Método para obtener datos del gráfico
    private fun obtenerDatos(nombre: String, apellido: String, edad: Float): LineData {
        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, edad))
        return LineData(LineDataSet(entries, "Edad de $nombre $apellido"))
    }
}