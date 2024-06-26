package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Nuevo_Pago_Pag3_Efec_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_pago_pag3_efec)

        // boton volver a la ventana anterior
        val btn_volver: Button = findViewById(R.id.image_back_button)
        btn_volver.setOnClickListener {
            finish()
        }

        // boton cancelar
        val btn_cancelar: Button = findViewById(R.id.container_btn_cancelar)
        btn_cancelar.setOnClickListener {
            irAPagos()
        }

        // boton anterior
        val btn_anterior: Button = findViewById(R.id.container_btn_anterior)
        btn_anterior.setOnClickListener {
            irAPag2Cuota()
        }

        // boton Confirmar
        val btn_confirmar: Button = findViewById(R.id.container_btn_confirmar)
        btn_confirmar.setOnClickListener {
            irAPag4Impres()
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

    private fun irAPag2Cuota(){
        val intent = Intent(this, Nuevo_Pago_Pag2_Cuota_Activity::class.java)
        startActivity(intent)
    }

    private fun irAPag4Impres(){
        val intent = Intent(this, Nuevo_Pago_Pag4_Confirm_Impres_Activity::class.java)
        startActivity(intent)
    }
}