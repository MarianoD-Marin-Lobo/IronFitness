package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton

class Nuevo_Pago_Pag1_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_pago_pag1)

        var nombresApellidos: EditText
        var nroIdentificacion: EditText
        var spinnerTipoIdentif: Spinner
        var nroAfiliado: EditText
        var btnSiguiente: Button

        nombresApellidos = findViewById(R.id.nuevo_pago_pag1_input_nombre_apellido_afiliado)
        nroIdentificacion = findViewById(R.id.inputNroIdentificacion)
        spinnerTipoIdentif = findViewById(R.id.np_pag1_tipoIdentif_spinner)
        nroAfiliado = findViewById(R.id.input_nro_afiliado)
        btnSiguiente = findViewById(R.id.container_btn_siguiente)

        val items = arrayOf("TIPO Id.", "DNI", "Nº Afiliado")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipoIdentif.adapter = adapter
        spinnerTipoIdentif.prompt = "TIPO Id."


        // boton siguiente
        btnSiguiente.setOnClickListener {
            val nombApell = nombresApellidos.text.toString()
            val nroIdentif = nroIdentificacion.text.toString()
            val tipoIdentif = spinnerTipoIdentif.selectedItem.toString()
            val nroAfil = nroAfiliado.text.toString()

            val intent = Intent(this, Nuevo_Pago_Pag2_Activity::class.java).apply {
                putExtra("nombApell", nombApell)
                putExtra("nroIdentif", nroIdentif)
                putExtra("tipoIdentif", tipoIdentif)
                putExtra("nroAfil", nroAfil)
            }

            startActivity(intent)
        }


        // boton volver a la ventana anterior
        val btn_volver: Button = findViewById(R.id.image_back_button)
        btn_volver.setOnClickListener {
            finish()
        }

        // boton cancelar
        val btn_cancelar: Button = findViewById(R.id.container_btn_cancelar)
        btn_cancelar.setOnClickListener {
            irAMenuPagos()
        }





        // Barra de navegacion
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

    private fun irAMenuPagos(){
        val intent = Intent(this, Menu_PagosActivity::class.java)
        startActivity(intent)
    }


    // Dentro de Nuevo_Pago_Pag1_Activity.kt



}