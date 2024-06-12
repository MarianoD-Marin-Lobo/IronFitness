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


    }
}
