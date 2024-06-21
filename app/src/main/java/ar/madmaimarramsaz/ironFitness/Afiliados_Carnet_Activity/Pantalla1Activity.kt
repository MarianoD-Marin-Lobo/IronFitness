package ar.madmaimarramsaz.ironFitness.Afiliados_Carnet_Activity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
    }
}
