import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.ChartData
import com.github.mikephil.charting.data.LineData
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class Informe(private val context: Context) {

    private val dbHelper = DBHelper(context)

    fun generarInformeEnAplicacion(datos: LineData, grafico: LineChart, notas: String) {
        grafico.description.isEnabled = true
        grafico.description.text = notas
        grafico.data = datos
        grafico.invalidate()
    }

    fun generarInformeEnPDF(datos: ChartData<*>, grafico: LineChart, notas: String): File? {
        return try {
            val directorio = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "Informes"
            )
            if (!directorio.exists()) {
                directorio.mkdirs()
            }

            val fechaHoraActual = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val archivoPDF = File(directorio, "Informe_$fechaHoraActual.pdf")

            val document = PdfDocument()
            val pageInfo = PdfDocument.PageInfo.Builder(grafico.width, grafico.height, 1).create()
            val page = document.startPage(pageInfo)
            val canvas = page.canvas

            grafico.draw(canvas)

            val paint = Paint()
            paint.color = Color.BLACK
            paint.textSize = 12f
            paint.style = Paint.Style.FILL

            val text = notas
            val textWidth = paint.measureText(text)
            val xPos = (canvas.width - textWidth) / 2
            val yPos = grafico.height + 40f

            canvas.drawText(text, xPos, yPos, paint)

            document.finishPage(page)
            val outputStream = FileOutputStream(archivoPDF)
            document.writeTo(outputStream)
            document.close()

            Toast.makeText(context, "Informe generado como PDF en Descargas", Toast.LENGTH_SHORT).show()

            archivoPDF
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Error al generar el informe como PDF", Toast.LENGTH_SHORT).show()
            null
        }
    }

}
