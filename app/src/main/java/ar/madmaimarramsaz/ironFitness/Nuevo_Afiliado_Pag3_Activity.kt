package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Nuevo_Afiliado_Pag3_Activity : AppCompatActivity() {

    private lateinit var inputDireccion: EditText
    private lateinit var inputCiudad: EditText
    private lateinit var inputCp: EditText
    private lateinit var inputEmail: EditText
    private lateinit var btnSiguiente: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_afiliado_pag3)

        inputDireccion = findViewById(R.id.inputDireccion)
        inputCiudad = findViewById(R.id.inputCiudad)
        inputCp = findViewById(R.id.inputCp)
        inputEmail = findViewById(R.id.inputEmail)
        btnSiguiente = findViewById(R.id.btnSiguiente)

        val esSocio = intent.getBooleanExtra("esSocio", false)
        val aptoMed = intent.getStringExtra("aptoMed") ?: ""
        val fechaAfil = intent.getStringExtra("fechaAfil") ?: ""
        val nombre = intent.getStringExtra("nombre") ?: ""
        val apellido = intent.getStringExtra("apellido") ?: ""
        val dni = intent.getStringExtra("dni") ?: ""
        val fechaNacimiento = intent.getStringExtra("fechaNacimiento") ?: ""


        btnSiguiente.setOnClickListener {
            val direccion = inputDireccion.text.toString()
            val ciudad = inputCiudad.text.toString()
            val cp = inputCp.text.toString()
            val email = inputEmail.text.toString()

            val intent = Intent(this, Nuevo_Afiliado_Pag4_Activity::class.java).apply {
                putExtra("direccion", direccion)
                putExtra("ciudad", ciudad)
                putExtra("codigoPostal", cp)
                putExtra("email", email)
                putExtra("esSocio", esSocio)
                putExtra("aptoMed", aptoMed)
                putExtra("fechaAfil", fechaAfil)
                putExtra("nombre", nombre)
                putExtra("apellido", apellido)
                putExtra("dni", dni)
                putExtra("fechaNacimiento", fechaNacimiento)
            }

            startActivity(intent)
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



    // Funciones barra de nav
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