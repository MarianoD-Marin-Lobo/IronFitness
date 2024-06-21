package ar.madmaimarramsaz.ironFitness.Estados_Cuenta_Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.madmaimarramsaz.ironFitness.R
import android.content.Intent

import android.view.View
import android.widget.Button

import ar.madmaimarramsaz.ironFitness.Estados_Cuenta_Activity.EstadoCuenta2Activity
import ar.madmaimarramsaz.ironFitness.Estados_Cuenta_Activity.EstadoCuenta3Activity
import ar.madmaimarramsaz.ironFitness.GestionAfiliadoActivity
import ar.madmaimarramsaz.ironFitness.HomeActivity
import ar.madmaimarramsaz.ironFitness.Menu_PagosActivity

class EstadoCuenta1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estado_cuenta1)

        // Aquí puedes encontrar los botones y configurar los listeners
        val button1 = findViewById<Button>(R.id.btn_cuotas_vencer_dia)
        val button2 = findViewById<Button>(R.id.btn_estados_de_cuenta)

        // Configurar onClickListener para button1
        button1.setOnClickListener {
            irAEstadoCuenta2()
        }

        // Configurar onClickListener para button2
        button2.setOnClickListener {
            irAEstadoCuenta3()
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
    private fun irAEstadoCuenta2() {
        val intent = Intent(this, EstadoCuenta2Activity::class.java)
        startActivity(intent)
    }

    private fun irAEstadoCuenta3() {
        val intent = Intent(this, EstadoCuenta3Activity::class.java)
        startActivity(intent)
    }

    // Fucniones Barra de navegación
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