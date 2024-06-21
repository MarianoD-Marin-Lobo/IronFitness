package ar.madmaimarramsaz.ironFitness.Afiliados_Carnet_Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.madmaimarramsaz.ironFitness.HomeActivity
import ar.madmaimarramsaz.ironFitness.Menu_PagosActivity
import ar.madmaimarramsaz.ironFitness.GestionAfiliadoActivity
import ar.madmaimarramsaz.ironFitness.R

class Pantalla1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla1)

        // boton volver a la ventana anterior
        val btn_volver: Button = findViewById(R.id.image_back_button)

        btn_volver.setOnClickListener {
            finish()
        }

        // barra de navegacion Boton 1 Pagar

        val btn_pagar: Button = findViewById(R.id.image_low_menu_quad)

        btn_pagar.setOnClickListener {
            val intent = Intent(this, Menu_PagosActivity::class.java)
            startActivity(intent)
        }

        // barra de navegacion Boton 2 ir a Home

        val btn_home: Button = findViewById(R.id.image_low_menu_quad1)

        btn_home.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // barra de navegacion Boton 3 ir a Gestión Afiliados

        val btn_gestionAfiliado: Button = findViewById(R.id.image_low_menu_quad2)

        btn_gestionAfiliado.setOnClickListener {
            val intent = Intent(this, GestionAfiliadoActivity::class.java)
            startActivity(intent)
        }
    }
}
