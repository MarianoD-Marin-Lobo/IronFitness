package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.app.DatePickerDialog
import java.util.*
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class Nuevo_Pago_Pag2_Activity : AppCompatActivity() {

    private lateinit var fechaPago : EditText
    private lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_pago_pag2)

        var spinnerItemACobrar: Spinner = findViewById(R.id.nuevo_pago_itemACobrar_spinner)
        val items = arrayOf("Item a cobrar", "Cuota MENSUAL", "Cuota DIARIA")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerItemACobrar.adapter = adapter
        spinnerItemACobrar.prompt = "Item a cobrar"

        var comentarioEquipamiento: EditText = findViewById(R.id.np_pag2_input_comentarios)
        fechaPago = findViewById(R.id.fechaPago)
        var importeAPagar: EditText = findViewById(R.id.np_pag2_input_importe)

        val nombApell = intent.getStringExtra("nombApell") ?: ""
        val nroIdentif = intent.getStringExtra("nroIdentif") ?: ""
        val tipoIdentif = intent.getStringExtra("tipoIdentif") ?: ""
        val nroAfil = intent.getStringExtra("nroAfil") ?: ""


        //seleccion calendario
        fechaPago.setOnClickListener {
            mostrarCalendario()
        }

        // boton siguiente
        val btn_siguiente: Button = findViewById(R.id.container_btn_siguiente)
        btn_siguiente.setOnClickListener {
            val tipoCuota = spinnerItemACobrar.selectedItem.toString()
            val comentEquip = comentarioEquipamiento.text.toString()
            val fechaPag = fechaPago.text.toString()
            val importeAPag = importeAPagar.text.toString()

            val intent = Intent(this, Nuevo_Pago_Pag3_Activity::class.java).apply {
                putExtra("nombApell", nombApell)
                putExtra("nroIdentif", nroIdentif)
                putExtra("tipoIdentif", tipoIdentif)
                putExtra("nroAfil", nroAfil)
                putExtra("tipoCuota", tipoCuota)
                putExtra("comentEquip", comentEquip)
                putExtra("fechaPag", fechaPag)
                putExtra("importeAPag", importeAPag)
            }
            if (tipoCuota == "Item a cobrar" || fechaPag.isEmpty() || importeAPag.isEmpty()) {
                Toast.makeText(this, "Por favor complete todos los campos antes de continuar.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else {
                startActivity(intent)
            }
        }



        // boton volver a la ventana anterior
        val btn_volver: Button = findViewById(R.id.image_back_button)
        btn_volver.setOnClickListener {
            finish()
        }

        // boton anterior
        val btn_anterior: Button = findViewById(R.id.container_btn_anterior)
        btn_anterior.setOnClickListener {
            irAPag1Actividad()
        }


        // boton cancelar ?
        val btn_cancelar: Button = findViewById(R.id.container_btn_cancelar)
        btn_cancelar.setOnClickListener {
            irAPag1Actividad()
        }

        // Barra de Navegacion
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

    // Funciones
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

    private fun irAPag1Actividad(){
        val intent = Intent(this, Nuevo_Pago_Pag1_Activity::class.java)
        startActivity(intent)
    }

//mostrar calendario
private fun mostrarCalendario() {
    val calendario = Calendar.getInstance()
    val añoActual = calendario.get(Calendar.YEAR)
    val mesActual = calendario.get(Calendar.MONTH)
    val diaActual = calendario.get(Calendar.DAY_OF_MONTH)

    val datePicker = DatePickerDialog(
        this,
        { _, año, mes, día ->
            // Formatear la fecha seleccionada
            val calendarioSeleccionado = Calendar.getInstance()
            calendarioSeleccionado.set(Calendar.YEAR, año)
            calendarioSeleccionado.set(Calendar.MONTH, mes)
            calendarioSeleccionado.set(Calendar.DAY_OF_MONTH, día)

            val formatoFecha = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val fechaFormateada = formatoFecha.format(calendarioSeleccionado.time)

            // Establecer el texto formateado en el EditText
            fechaPago.setText(fechaFormateada)
        },
        añoActual,
        mesActual,
        diaActual
    )

    // Mostrar el diálogo de selección de fecha
    datePicker.show()
}
}