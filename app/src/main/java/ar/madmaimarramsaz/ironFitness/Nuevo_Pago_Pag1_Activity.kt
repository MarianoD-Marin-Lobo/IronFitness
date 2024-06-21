package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.text.Html
import android.widget.Button

class Nuevo_Pago_Pag1_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_pago_pag1)

        val spinner: Spinner = findViewById(R.id.nuevo_pago_pag1_spinner)

        val items = arrayOf("TIPO Id.", "DNI", "Nº Afiliado")


        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner.adapter = adapter


        spinner.prompt = "TIPO Id."

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