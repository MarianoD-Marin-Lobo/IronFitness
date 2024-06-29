package ar.madmaimarramsaz.ironFitness

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.ViewGroup
import android.widget.Button
import android.widget.ScrollView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ar.madmaimarramsaz.ironFitness.BaseDatos
import ar.madmaimarramsaz.ironFitness.Entidades.Pago
import ar.madmaimarramsaz.ironFitness.repositories.PagoRepository
import java.io.File
import java.io.FileOutputStream

class Nuevo_Pago_Pag4_Activity : AppCompatActivity() {
    private lateinit var pago: Pago
    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_pago_pag4)

        /*
        // Obtiene el ID del pago del intent
        val pagoId = intent.getIntExtra("pagoId", 0)
        //--------------------------------
        // Se obtiene una instancia de la Base de Datos
        val baseDatos = BaseDatos(this)
        // Busca los detalles del pago en la base de datos usando el ID
        pago = baseDatos.getPagoById(pagoId)!!

        // Obtiene la TableView del diseño XML
        tableLayout = findViewById(R.id.tblLyt_detallePago) // Suponiendo que la TableView tiene este ID en tu XML

        // Crea una TablaLayout para mostrar los detalles del pago
        val tablaDetallesPago = TableLayout(this)
        val parametrosTabla = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        tablaDetallesPago.layoutParams = parametrosTabla

        // Añade encabezados de la tabla
        val filaEncabezado = TableRow(this)
        val parametrosFila = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        filaEncabezado.layoutParams = parametrosFila
        val encabezado1 = TextView(this)
        encabezado1.text = "Detalle de pago"
        val parametrosEncabezado1 = TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        encabezado1.layoutParams = parametrosEncabezado1
        val encabezado2 = TextView(this)
        encabezado2.text = "" // Columna vacía para espaciado
        val parametrosEncabezado2 = TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        encabezado2.layoutParams = parametrosEncabezado2
        filaEncabezado.addView(encabezado1)
        filaEncabezado.addView(encabezado2)
        tablaDetallesPago.addView(filaEncabezado)

        // Añade filas con detalles del pago
        agregarFila(tablaDetallesPago, "Nombre completo:", pago.nombresApellidos)
        agregarFila(tablaDetallesPago, "Tipo Identificación:", pago.tipoIdentificacion)
        agregarFila(tablaDetallesPago, "Nº Identificación:", pago.nroIdentificacion)
        agregarFila(tablaDetallesPago, "Nº Afiliado:", pago.nroAfiliado)
        agregarFila(tablaDetallesPago, "Tipo Cuota:", pago.tipoCuota)
        agregarFila(tablaDetallesPago, "Coment. / Equipamiento:", pago.comentarioEquipamiento)
        agregarFila(tablaDetallesPago, "Fecha Pago:", pago.fechaPago)
        agregarFila(tablaDetallesPago, "Importe:", "$ " + pago.importeAPagar)
        agregarFila(tablaDetallesPago, "Modalidad de Pago:", pago.modalidadDePago)



        // Configura el listener del clic para el botón "Generar PDF"
        val buttonGenerarPDF = findViewById<Button>(R.id.btn_generar_pdf)
        buttonGenerarPDF.setOnClickListener {
            savePaymentRecordAsPDF(pago)
        }
    */
        // boton volver a la ventana anterior
        val btn_volver: Button = findViewById(R.id.image_back_button)
        btn_volver.setOnClickListener {
            finish()
        }

        // barra de navegacion Boton 1 Pagar
        val btn_pagar: Button = findViewById(R.id.image_low_menu_quad)
        btn_pagar.setOnClickListener {
            irAPagos()
        }

        // barra de navegacion Boton 2 ir a Home
        val btn_home: Button = findViewById(R.id.image_low_menu_quad1)
        btn_home.setOnClickListener {
            irAHome()
        }

        // barra de navegacion Boton 3 ir a Gestión Afiliados
        val btn_gestionAfiliado: Button = findViewById(R.id.image_low_menu_quad2)
        btn_gestionAfiliado.setOnClickListener {
            irAGestionAfiliado()
        }
    }

    fun generatePaymentRecordPDF(pago: Pago): String {

        val pdfContent = StringBuilder()

        pdfContent.appendLine("Nombre completo: ${pago.nombresApellidos}")
        pdfContent.appendLine("Número de identificación: ${pago.nroIdentificacion}")
        pdfContent.appendLine("Tipo de identificación: ${pago.tipoIdentificacion}")
        pdfContent.appendLine("Tipo de identificación: ${pago.nroAfiliado}")
        pdfContent.appendLine("Tipo de identificación: ${pago.tipoCuota}")
        pdfContent.appendLine("Tipo de identificación: ${pago.comentarioEquipamiento}")
        pdfContent.appendLine("Tipo de identificación: ${pago.fechaPago}")
        pdfContent.appendLine("Tipo de identificación: ${pago.importeAPagar}")
        pdfContent.appendLine("Tipo de identificación: ${pago.modalidadDePago}")

        return pdfContent.toString()
    }

    fun savePaymentRecordAsPDF(pago: Pago) {
        val pdfContent = generatePaymentRecordPDF(pago)
        val filename = "pago_${pago.nombresApellidos.replace(' ', '_')}.pdf"


        val context = applicationContext

        // Obtener la carpeta Descargas
        val downloadsDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)

        // Crear el archivo en la carpeta Descargas
        val file = File(downloadsDir, filename)

        // Abrir flujo de salida y escribir contenido
        val outputStream = FileOutputStream(file)
        outputStream.write(pdfContent.toByteArray())
        outputStream.close()
    }



    private fun agregarFila(tabla: TableLayout, etiqueta: String, valor: String) {
        val fila = TableRow(this)
        val parametrosFila = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        fila.layoutParams = parametrosFila

        val textViewEtiqueta = TextView(this)
        textViewEtiqueta.text = etiqueta
        val parametrosEtiqueta = TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 0.5f)
        textViewEtiqueta.layoutParams = parametrosEtiqueta
        fila.addView(textViewEtiqueta)

        val textViewValor = TextView(this)
        textViewValor.text = valor
        val parametrosValor = TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 0.5f)
        textViewValor.layoutParams = parametrosValor
        fila.addView(textViewValor)

        tabla.addView(fila)
    }

    private fun generarPDF(pago: Pago) {
        // Usa una librería de generación de PDF como iTextPDF o PDFView para crear un PDF
        // a partir de los detalles del pago y mostrarlo o guardarlo según sea necesario
    }



    private fun irAPagos(){
        val intent = Intent(this, Menu_PagosActivity::class.java)
        startActivity(intent)
    }

    private fun irAHome(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun irAGestionAfiliado(){
        val intent = Intent(this, GestionAfiliadoActivity::class.java)
        startActivity(intent)
    }
}