package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Nuevo_Afiliado_Pag2_Activity : AppCompatActivity() {

    private lateinit var inputNombre: EditText
    private lateinit var inputApellido: EditText
    private lateinit var inputTipo: Spinner
    private lateinit var inputDni: EditText
    private lateinit var inputFechaNacimiento: EditText
    private lateinit var btnSiguiente: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_afiliado_pag2)

        inputNombre = findViewById(R.id.inputNombre)
        inputApellido = findViewById(R.id.inputApellido)
        inputTipo = findViewById(R.id.nuevo_pago_pag1_spinner)
        inputDni = findViewById(R.id.inputDni)
        inputFechaNacimiento = findViewById(R.id.inputFechaNacimiento)
        btnSiguiente = findViewById(R.id.btnSiguiente)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.identification_types,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        inputTipo.adapter = adapter

        val esSocio = intent.getBooleanExtra("esSocio", false)
        val aptoMed = intent.getStringExtra("aptoMed") ?: ""
        val fechaAfil = intent.getStringExtra("fechaAfil") ?: ""


        btnSiguiente.setOnClickListener {
            val nombre = inputNombre.text.toString()
            val apellido = inputApellido.text.toString()
            val dni = inputDni.text.toString()
            val fechaNacimiento = inputFechaNacimiento.text.toString()
            val tipoDoc = inputTipo.selectedItem.toString()

            val intent = Intent(this, Nuevo_Afiliado_Pag3_Activity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("apellido", apellido)
                putExtra("tipoDoc", tipoDoc)
                putExtra("dni", dni)
                putExtra("fechaNacimiento", fechaNacimiento)
                putExtra("esSocio", esSocio)
                putExtra("aptoMed", aptoMed)
                putExtra("fechaAfil", fechaAfil)
            }
            startActivity(intent)
            Log.d("NuevoAfiliado", "Tipo de documento: $tipoDoc")

        }

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

}