package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val imageButtonAfiliado: ImageButton = findViewById(R.id.imageButtonAfiliado)

        imageButtonAfiliado.setOnClickListener {
            val intent = Intent(this, GestionAfiliadoActivity::class.java)
            startActivity(intent)
        }

        val btn_cuotas_vencer_dia: ImageButton = findViewById(R.id.btn_cuotas_vencer_dia)

        imageButtonAfiliado.setOnClickListener {
            val intent = Intent(this, GestionAfiliadoActivity::class.java)
            startActivity(intent)
        }

        val btn_estados_de_cuenta: ImageButton = findViewById(R.id.btn_estados_de_cuenta)

        imageButtonAfiliado.setOnClickListener {
            val intent = Intent(this, Estados_Cuenta_Activity::class.java)
            startActivity(intent)
        }

    }
}
