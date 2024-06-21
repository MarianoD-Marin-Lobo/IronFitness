package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import ar.madmaimarramsaz.ironFitness.Estados_Cuenta_Activity.EstadoCuenta1Activity
import ar.madmaimarramsaz.ironFitness.Afiliados_Carnet_Activity.Pantalla1Activity


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // abre la ventana de Gestion de Afiliados
        val imageButtonAfiliado: ImageButton = findViewById(R.id.imageButtonAfiliado)

        imageButtonAfiliado.setOnClickListener {
            val intent = Intent(this, GestionAfiliadoActivity::class.java)
            startActivity(intent)
        }

        // abre la ventana de Carnets
        val btn_carnets: ImageButton = findViewById(R.id.imageButton2)

        btn_carnets.setOnClickListener {
            val intent = Intent(this, Pantalla1Activity::class.java)
            startActivity(intent)
        }

        // abre la ventana de Estados de Cuenta
        val btn_estados_de_cuenta: ImageButton = findViewById(R.id.imageButton3)

        btn_estados_de_cuenta.setOnClickListener {
            val intent = Intent(this, EstadoCuenta1Activity::class.java)
            startActivity(intent)
        }


        // boton volver a la ventana anterior
            val btn_volver: Button = findViewById(R.id.image_back_button)

        btn_volver.setOnClickListener {
            finish()
        }

        // barra de navegacion Boton 1

        val btn_pagar: Button = findViewById(R.id.image_low_menu_quad)

        btn_pagar.setOnClickListener {
            val intent = Intent(this, Menu_PagosActivity::class.java)
            startActivity(intent)
        }

        // barra de navegacion Boton 2 ninguno

        // barra de navegacion Boton 3 ir a gestion afiliados

        val btn_home: Button = findViewById(R.id.image_low_menu_quad2)

        btn_home.setOnClickListener {
            val intent = Intent(this, GestionAfiliadoActivity::class.java)
            startActivity(intent)
        }

    }
}
