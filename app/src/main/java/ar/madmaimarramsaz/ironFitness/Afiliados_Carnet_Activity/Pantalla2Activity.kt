package ar.madmaimarramsaz.ironFitness.Afiliados_Carnet_Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.madmaimarramsaz.ironFitness.Afiliados_Carnet_Activity.Pantalla1Activity
import ar.madmaimarramsaz.ironFitness.R

class Pantalla2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla2)


        // boton volver a la ventana anterior
        val btn_volver: Button = findViewById(R.id.image_back_button)
        btn_volver.setOnClickListener {
            finish()
        }

        // boton imprimir
        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener {
            irAImprimir()
        }

        // otro boton volver
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
           irACarnets()
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

    private fun irACarnets(){
        val intent = Intent(this, Pantalla1Activity::class.java)
        startActivity(intent)
    }
    private fun irAImprimir(){
        val intent = Intent(this, Impresion_Comprobantes_Activity::class.java)
        startActivity(intent)
    }
}