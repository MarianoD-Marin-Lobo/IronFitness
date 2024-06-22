package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Nuevo_Pago_Pag2_Actividad_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_pago_pag2_actividad)

        // Spinner elegir actividad a realizar
        val spinner: Spinner = findViewById(R.id.nuevo_pago_actividad_spinner)
        val items = arrayOf("Actividad 1", "Actividad 2", "Actividad 3")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter
        spinner.prompt = "ACTIVIDAD A REALIZAR"

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

            // boton siguiente
            val btn_siguiente: Button = findViewById(R.id.container_btn_siguiente)
            btn_siguiente.setOnClickListener {
                irAPag2Cuota()
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

    private fun irAPag2Cuota(){
        val intent = Intent(this, Nuevo_Pago_Pag2_Cuota_Activity::class.java)
        startActivity(intent)
    }
}